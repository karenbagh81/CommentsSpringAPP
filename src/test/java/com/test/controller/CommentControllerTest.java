package com.test.controller;

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


/*    @Test(timeout = 4000)
    public void save() {
        commentService.saveComment(comment);
    }*/

    @Test
    public void saveThousandTimes() {
        for (int i = 0; i < 10; i++) {
            Comment comment = new Comment();
            comment.setComment("Send comment " + i);
            try {
                commentService.saveComment(comment);
            } catch (RuntimeException e) {
                e.getMessage();
            }
        }
    }
}