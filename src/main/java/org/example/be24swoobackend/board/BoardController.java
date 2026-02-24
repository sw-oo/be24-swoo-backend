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

    @PostMapping
    public ResponseEntity create(@RequestBody BoardDto.Create dto) {
        boardService.save(dto);
        return ResponseEntity.ok("save success");
    }

    @GetMapping
    public ResponseEntity list() {
        return ResponseEntity.ok(boardService.list());
    }

    @GetMapping("/{idx}")
    public ResponseEntity findById(@PathVariable Long idx) {
        return ResponseEntity.ok(boardService.findById(idx));
    }

    @GetMapping("/search")
    public ResponseEntity findByTitle(@RequestParam String title) {
        return ResponseEntity.ok(boardService.findByTitle(title));
    }
}
