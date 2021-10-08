package com.salmon.board.controller;

import com.salmon.board.domain.dto.LikeRequestDto;
import com.salmon.board.exception.AlreadyLikeUpException;
import com.salmon.board.security.UserDetailsImpl;
import com.salmon.board.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    //Create
    @PostMapping("/like/save")
    @ResponseBody
    public HashMap likeUpOrDown(@RequestBody @ModelAttribute LikeRequestDto likeRequestDto,
                            @AuthenticationPrincipal UserDetailsImpl userDetails) throws AlreadyLikeUpException {
        String likeUpOrDown = likeService.likeUpOrDown(likeRequestDto.getBoardId(), userDetails.getUser());

        HashMap result = new HashMap<>();
        result.put("msg", likeUpOrDown);

        return result;
    }

    //Update

    //Delete


}
