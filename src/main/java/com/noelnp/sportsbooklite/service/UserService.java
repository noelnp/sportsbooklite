package com.noelnp.sportsbooklite.service;

import com.noelnp.sportsbooklite.dto.user.CreateUserRequest;
import com.noelnp.sportsbooklite.dto.user.UserResponse;
import com.noelnp.sportsbooklite.entity.User;
import com.noelnp.sportsbooklite.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse registerUser(CreateUserRequest request) {
        String hash = passwordEncoder.encode(request.password());

        User user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPasswordHash(hash);

        User saved = userRepository.save(user);

        return new UserResponse(
                saved.getId(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getEmail(),
                saved.getCreatedAt());

    }
}
