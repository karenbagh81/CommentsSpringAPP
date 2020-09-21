package com.test.controller;

import com.test.BusinessLogic.StatisticOfComentsAndDelivered;
import com.test.model.Comment;
import com.test.service.interfaces.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentControllerTest {

    @Autowired
    private CommentService commentService;

    @Test(timeout = 1000)
    public void saveCommentShouldReturnFasterThanOneSecond() {
        Comment comment = new Comment();
        comment.setComment("Hi my friends");
        try {
            commentService.saveComment(comment);
        } catch (RuntimeException e) {
            e.getMessage();
        }

    }

    @Test
    public void saveThousandTimes() {
        int commentsCount = 30;
        double commentsSendedCount = 0;
        double isDeliveredCount = 0;

        for (int i = 0; i < commentsCount; i++) {
            Comment comment = new Comment();
            comment.setComment("Send comment ********* " + i);

            try {
                StatisticOfComentsAndDelivered statistic = commentService.saveComment(comment);
                if (statistic.getComment() != null) {
                    commentsSendedCount++;

                    if (statistic.isDelivered()) {
                        isDeliveredCount++;
                    }
                }
            } catch (RuntimeException e) {
                e.getMessage();
            }

        }

        System.out.println("Comments sended percent is " +
                Math.round((commentsSendedCount / commentsCount) * 100) + "%");

        if (commentsSendedCount != 0) {
            System.out.println("Notification delivered percent is " +
                    Math.round((isDeliveredCount / commentsSendedCount) * 100) + "%");
        } else {
            System.out.println("Notification delivered percent is 0%");
        }
    }
}