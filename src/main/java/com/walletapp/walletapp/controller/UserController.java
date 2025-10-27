package com.walletapp.walletapp.controller;

import com.walletapp.walletapp.dto.CreateUserRequest;
import com.walletapp.walletapp.dto.TransactionRequest;
import com.walletapp.walletapp.dto.UserResponse;
import com.walletapp.walletapp.model.User;
import com.walletapp.walletapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        User user = userService.createUser(request.getName(), request.getBalance());
        return ResponseEntity.ok(new UserResponse(user.getId(), user.getName(), user.getBalance()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(new UserResponse(user.getId(), user.getName(), user.getBalance()));
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<UserResponse> addMoney(@PathVariable Long id, @Valid @RequestBody TransactionRequest request) {
        User updated = userService.addMoney(id, request.getAmount());
        return ResponseEntity.ok(new UserResponse(updated.getId(), updated.getName(), updated.getBalance()));
    }

    @PostMapping("/{id}/spend")
    public ResponseEntity<UserResponse> spendMoney(@PathVariable Long id, @Valid @RequestBody TransactionRequest request) {
        User updated = userService.spendMoney(id, request.getAmount());
        return ResponseEntity.ok(new UserResponse(updated.getId(), updated.getName(), updated.getBalance()));
    }
}
