package com.test.service.implementations;

import com.test.BusinessLogic.BusinessLogic;
import com.test.model.Comment;
import com.test.model.Notification;
import com.test.repository.NotificationRepository;
import com.test.service.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    @Transactional
    public boolean saveNotification(Comment comment) {
        Notification notification = new Notification();
        notification.setTime(new Date());
        notification.setComment(comment);
        try {
            BusinessLogic.doSomeWorkOnNotification();
            notification.setDelivered(true);
        } catch (RuntimeException e) {
            e.getMessage();
        }
        notificationRepository.save(notification);
        return notification.isDelivered();
    }

    @Override
    public Page<Notification> getAll(Pageable pageable) {
        Page<Notification> page = notificationRepository.findAll(pageable);
        return page;
    }
}
