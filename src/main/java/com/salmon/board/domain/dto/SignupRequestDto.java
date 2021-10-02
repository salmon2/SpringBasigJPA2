package com.salmon.board.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";

    @Getter
    public static class ItemDto {
        private String title;
        private String link;
        private String image;
        private int lprice;
    }
}