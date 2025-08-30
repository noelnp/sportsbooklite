package com.noelnp.sportsbooklite.controller;

import com.noelnp.sportsbooklite.dto.CreateUserRequest;
import com.noelnp.sportsbooklite.dto.UserResponse;
import com.noelnp.sportsbooklite.repository.UserRepository;
import com.noelnp.sportsbooklite.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        UserResponse created = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }


}
