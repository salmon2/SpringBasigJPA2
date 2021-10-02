package com.salmon.board.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KakaoUserInfoDto {
    private Long id;
    private String nickname;
    private String email;
}
