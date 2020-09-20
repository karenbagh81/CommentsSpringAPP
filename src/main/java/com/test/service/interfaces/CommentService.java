package com.test.service.interfaces;

import com.test.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {

    void saveComment(Comment comment);

    Page<Comment> getAll(Pageable pageable);
}
