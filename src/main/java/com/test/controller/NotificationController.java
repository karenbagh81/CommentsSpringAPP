package com.test.controller;

import com.test.model.Comment;
import com.test.model.Notification;
import com.test.service.interfaces.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public ResponseEntity getAll() {
        Sort sort = Sort.by("commentId");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Notification> page = notificationService.getAll(pageable);
        return ResponseEntity.ok(page);
    }
}
