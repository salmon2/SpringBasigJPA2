package com.salmon.board.controller;

import com.salmon.board.domain.Comment;
import com.salmon.board.domain.dto.CommentRequestDto;
import com.salmon.board.security.UserDetailsImpl;
import com.salmon.board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/comment/update")
    public Comment commentUpdate(@RequestParam Long id, @RequestBody @ModelAttribute CommentRequestDto commentRequestDto){
        Comment updateComment = commentService.update(id, commentRequestDto);

        return updateComment;
    }


    // Delete


}
