package com.noelnp.sportsbooklite.modules.user.presentation.controller;

import com.noelnp.sportsbooklite.modules.user.presentation.dto.CreateUserRequest;
import com.noelnp.sportsbooklite.modules.user.presentation.dto.UserResponse;
import com.noelnp.sportsbooklite.exception.ApiRequestException;
import com.noelnp.sportsbooklite.modules.user.app.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse created = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }

    @GetMapping("/exception")
    public String getException() {
        throw new ApiRequestException("Something went wrong");
    }


}
