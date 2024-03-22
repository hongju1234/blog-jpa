package com.estsoft.blogjpa.dto;

import com.estsoft.blogjpa.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() { // 생성자를 사용하여 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
