package com.namnp.portfolio_service.controller;

import com.namnp.portfolio_service.dto.UserDTO;
import com.namnp.portfolio_service.service.iUserService;
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
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
        return new ResponseEntity(userService.save(userDTO), HttpStatus.OK);
    }
}
