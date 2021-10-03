package com.salmon.board.controller;

import com.salmon.board.domain.Comment;
import com.salmon.board.domain.dto.CommentRequestDto;
import com.salmon.board.security.UserDetailsImpl;
import com.salmon.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;


    // Create
    @PostMapping("/comment/save")
    public Comment commentSave(@RequestBody @ModelAttribute CommentRequestDto commentRequestDto,
                               @AuthenticationPrincipal UserDetailsImpl userDetails
                              ){
        Comment saveComment = commentService.save(commentRequestDto, userDetails);

        return saveComment;
    }


    // Update


    // Delete


}
