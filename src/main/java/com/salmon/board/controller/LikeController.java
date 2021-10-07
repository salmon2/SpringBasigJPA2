package com.salmon.board.controller;

import com.salmon.board.domain.Like;
import com.salmon.board.security.UserDetailsImpl;
import com.salmon.board.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    //Create
    @PostMapping("/like/save")
    public Like likeSave(@RequestBody @ModelAttribute Long boardId,
                         @AuthenticationPrincipal UserDetailsImpl userDetails){
        Like saveLike = likeService.save(boardId, userDetails.getUser());

        return saveLike;
    }

    //Update

    //Delete


}
