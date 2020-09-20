package com.test.service.implementations;

import com.test.BusinessLogic.BusinessLogic;
import com.test.model.Comment;
import com.test.repository.CommentRepository;
import com.test.service.interfaces.CommentService;
import com.test.service.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private NotificationService notificationService;

    @Transactional
    public void saveComment(Comment comment) {
        Date date = new Date();
        comment.setTime(date.toString());
        commentRepository.save(comment);
        BusinessLogic.doSomeWorkOnCommentCreation();
        try {
            notificationService.saveNotification(comment.getId());
        }catch (RuntimeException e){
            e.getMessage();
        }
    }

    @Override
    public Page<Comment> getAll(Pageable pageable) {
        Page<Comment> page = commentRepository.findAll(pageable);
        return page;
    }
}
