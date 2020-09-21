package com.test.service.interfaces;

import com.test.BusinessLogic.StatisticOfComentsAndDelivered;
import com.test.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    StatisticOfComentsAndDelivered saveComment(Comment comment);

    Page<Comment> getAll(Pageable pageable);
}
