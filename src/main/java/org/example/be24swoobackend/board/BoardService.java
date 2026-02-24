package org.example.be24swoobackend.board;

import lombok.RequiredArgsConstructor;
import org.example.be24swoobackend.board.model.Board;
import org.example.be24swoobackend.board.model.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDto.Create dto) {
        boardRepository.save(dto.toEntity());
    }

    public List<BoardDto.Read> list() {
        List<Board> list = boardRepository.findAll();
        return list.stream().map(BoardDto.Read::from).toList();
    }

    public BoardDto.Read findById(Long idx) {
         return BoardDto.Read.from(boardRepository.findById(idx).orElseThrow());
    }

    public BoardDto.Read findByTitle(String title) {
        return BoardDto.Read.from(boardRepository.findByTitle(title).orElseThrow());
    }
}
