package org.example.be24swoobackend.user;

import lombok.RequiredArgsConstructor;
import org.example.be24swoobackend.user.model.User;
import org.example.be24swoobackend.user.model.UserDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signup(UserDto.Signup dto) {
        userRepository.save(dto.toEntity());
    }
    public UserDto.LoginRes login(UserDto.LoginReq dto) {
        User user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword()).orElseThrow();
        return UserDto.LoginRes.from(user);
    }
}
