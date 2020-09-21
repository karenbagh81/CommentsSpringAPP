package com.test.service.implementations;

import com.test.BusinessLogic.BusinessLogic;
import com.test.BusinessLogic.StatisticOfComentsAndDelivered;
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
    public StatisticOfComentsAndDelivered saveComment(Comment comment) {
        StatisticOfComentsAndDelivered statisticOfComentsAndDelivered = new StatisticOfComentsAndDelivered();
        boolean isDelivered = false;
        comment.setTime(new Date());
        Comment comment1 = commentRepository.save(comment);
        BusinessLogic.doSomeWorkOnCommentCreation();
        isDelivered = notificationService.saveNotification(comment1);
        statisticOfComentsAndDelivered.setComment(comment1);
        statisticOfComentsAndDelivered.setDelivered(isDelivered);
        return statisticOfComentsAndDelivered;
    }

    @Override
    public Page<Comment> getAll(Pageable pageable) {
        Page<Comment> page = commentRepository.findAll(pageable);
        return page;
    }
}
