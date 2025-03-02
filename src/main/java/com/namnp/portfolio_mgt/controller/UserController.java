package com.namnp.portfolio_mgt.controller;

import com.namnp.portfolio_mgt.dto.UserDTO;
import com.namnp.portfolio_mgt.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    iUserService userService;


    @GetMapping("get/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.save(userDTO));
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO){
        String result = userService.authenticate(userDTO);
        return result.equals("Access Denied") ? ResponseEntity.status(HttpStatus.FORBIDDEN).body(result) : ResponseEntity.ok(result);
    }
}
