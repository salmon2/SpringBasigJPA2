package com.salmon.board.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {
    private String title;
    private String writer;
    private String contents;
    private String createdAt;
}
