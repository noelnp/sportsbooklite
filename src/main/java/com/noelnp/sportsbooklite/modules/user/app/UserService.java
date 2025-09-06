package com.noelnp.sportsbooklite.modules.user.app;

import com.noelnp.sportsbooklite.modules.user.presentation.dto.CreateUserRequest;
import com.noelnp.sportsbooklite.modules.user.infra.mapper.UserEntityMapper;
import com.noelnp.sportsbooklite.modules.user.presentation.dto.UserResponse;
import com.noelnp.sportsbooklite.modules.user.infra.jpa.UserEntity;
import com.noelnp.sportsbooklite.modules.user.domain.exception.UserAlreadyExistsException;
import com.noelnp.sportsbooklite.modules.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserEntityMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse registerUser(CreateUserRequest request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new UserAlreadyExistsException("Email already taken " + request.email());
        }

        String hash = passwordEncoder.encode(request.password());

        UserEntity user = new UserEntity();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPasswordHash(hash);

        UserEntity saved = userRepository.save(user);

        return userMapper.toResponse(saved);

    }
}
