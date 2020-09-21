package com.test.service.implementations;

import com.test.model.Comment;
import com.test.service.interfaces.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    Comment comment = new Comment();

    {
        comment.setComment("Hi my friend");
    }

    @Test(timeout = 5000)
    public void saveCommentShoulReturnFasterThanOneSecond() {
        commentService.saveComment(comment);
    }
}