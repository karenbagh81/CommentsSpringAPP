package com.test.service.interfaces;

import com.test.model.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationService {

    void saveNotification(int commentId);

    Page<Notification> getAll(Pageable pageable);
}
