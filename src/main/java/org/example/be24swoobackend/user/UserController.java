package org.example.be24swoobackend.user;

import lombok.RequiredArgsConstructor;
import org.example.be24swoobackend.user.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserDto.Signup dto) {
        userService.signup(dto);
        return ResponseEntity.ok("create Success");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto.LoginReq dto) {
        UserDto.LoginRes res = userService.login(dto);
        return ResponseEntity.ok(res);
    }
}
