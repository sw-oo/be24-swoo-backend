package org.example.be24swoobackend.board;

import lombok.RequiredArgsConstructor;
import org.example.be24swoobackend.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = "http://localhost:5173",
        allowCredentials = "true"
)

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    // 게시글 생성
    @PostMapping
    public ResponseEntity create(@RequestBody BoardDto.Create dto) {
        boardService.save(dto);
        return ResponseEntity.ok("save success");
    }

    // 게시글 목록 조회
    @GetMapping
    public ResponseEntity list() {
        return ResponseEntity.ok(boardService.list());
    }

    // 게시글 상세 조회 - id
    @GetMapping("/{idx}")
    public ResponseEntity findById(@PathVariable Long idx) {
        return ResponseEntity.ok(boardService.findById(idx));
    }

    // 게시글 상세 조회 - title
    @GetMapping("/search")
    public ResponseEntity findByTitle(@RequestParam String title) {
        return ResponseEntity.ok(boardService.findByTitle(title));
    }

    // 게시글 수정
    @PutMapping("/update/{idx}")
    public ResponseEntity updateById(@PathVariable Long idx, @RequestBody BoardDto.Create dto) {
        return ResponseEntity.ok(boardService.update(idx , dto));
    }

    // 게시글 삭제
    @DeleteMapping ("/delete/{idx}")
    public ResponseEntity deleteById(@PathVariable Long idx) {
        boardService.delete(idx);
        return ResponseEntity.ok("delete success");
    }
}
