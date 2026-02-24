package org.example.be24swoobackend.board.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String title;
    String contents;

    public void update(BoardDto.Create dto) {
        this.title = dto.title;
        this.contents = dto.contents;
    }
}
