package com.salmon.board.domain.dto;

import com.salmon.board.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;

    //게시판 정보들
    private Long userId;
    private String title;
    private String writer;
    private String contents;
    private String createdAt;


    //comment 정보들
    private List<CommentResponseDto> commentList;
    private Long likeSize;

}
