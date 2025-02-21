package com.namnp.portfolio_service.impl;

import com.namnp.portfolio_service.dto.UserDTO;
import com.namnp.portfolio_service.mapper.UserMapper;
import com.namnp.portfolio_service.model.User;
import com.namnp.portfolio_service.repository.UserRepository;
import com.namnp.portfolio_service.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements iUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDTO findById(long id) {
        return userMapper.toDTO(userRepository.findById(id).orElse(new User()));
    }
}
