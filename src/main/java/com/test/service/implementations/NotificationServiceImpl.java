package com.test.service.implementations;

import com.test.BusinessLogic.BusinessLogic;
import com.test.model.Notification;
import com.test.repository.NotificationRepository;
import com.test.service.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void saveNotification(int commentId) {
        //boolean delivered = false;
        Notification notification = new Notification();
        Date date = new Date();
        notification.setCommentId(commentId);
        notification.setTime(date.toString());
        notificationRepository.save(notification);
        BusinessLogic.doSomeWorkOnNotification();
        notification.setDelivered(true);
        notificationRepository.save(notification);
    }

    @Override
    public Page<Notification> getAll(Pageable pageable) {
        Page<Notification> page = notificationRepository.findAll(pageable);
        return page;
    }
}
