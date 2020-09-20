package com.test.controller;

import com.test.model.Comment;
import com.test.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;


    @PutMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Comment comment) {
        commentService.saveComment(comment);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAll() {
        Sort sort = Sort.by("comment");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<Comment> page = commentService.getAll(pageable);
        return ResponseEntity.ok(page);
    }
}
