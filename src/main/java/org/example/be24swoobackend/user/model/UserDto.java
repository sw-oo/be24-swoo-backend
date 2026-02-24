package org.example.be24swoobackend.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserDto {
    @Getter
    public static class Signup {
        String email;
        String name;
        String password;

        public User toEntity() {
            return User.builder()
                    .email(getEmail())
                    .name(getName())
                    .password(getPassword())
                    .build();
        }
    }

    @Getter
    public static class LoginReq {
        String email;
        String password;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class LoginRes {
        Long idx;
        String email;
        String name;

        public static LoginRes from(User entity) {
            return LoginRes.builder()
                    .idx(entity.getIdx())
                    .email(entity.getEmail())
                    .name(entity.getName())
                    .build();
        }
    }
}
