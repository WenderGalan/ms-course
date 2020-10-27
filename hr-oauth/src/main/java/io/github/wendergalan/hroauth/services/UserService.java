package io.github.wendergalan.hroauth.services;

import io.github.wendergalan.hroauth.entities.User;
import io.github.wendergalan.hroauth.feignclients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            log.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        log.info("Email found: " + email);
        return user;
    }
}
