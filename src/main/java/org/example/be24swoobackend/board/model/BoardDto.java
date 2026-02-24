package org.example.be24swoobackend.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class BoardDto {
    @Getter
    public static class Create {
        String title;
        String contents;

        public Board toEntity() {
            return Board.builder()
                    .title(getTitle())
                    .contents(getContents())
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Read {
        Long idx;
        String title;
        String contents;

        public static Read from(Board entity) {
            return Read.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .build();
        }
    }
}
