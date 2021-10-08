package com.salmon.board.controller;

import com.salmon.board.domain.dto.LikeRequestDto;
import com.salmon.board.security.UserDetailsImpl;
import com.salmon.board.service.LikeService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Api(tags={"좋아요 관련 APi"})
public class LikeController {
    private final LikeService likeService;

    //Create
    @PostMapping("/like/save")
    @ResponseBody
    public HashMap likeUpOrDown(@RequestBody @ModelAttribute LikeRequestDto likeRequestDto,
                            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        String likeUpOrDown = likeService.likeUpOrDown(likeRequestDto.getBoardId(), userDetails.getUser());

        HashMap result = new HashMap<>();
        result.put("msg", likeUpOrDown);

        return result;
    }

    //Update

    //Delete


}
