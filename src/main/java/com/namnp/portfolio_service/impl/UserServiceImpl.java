package com.namnp.portfolio_service.impl;

import com.namnp.portfolio_service.dto.UserDTO;
import com.namnp.portfolio_service.mapper.UserMapper;
import com.namnp.portfolio_service.model.User;
import com.namnp.portfolio_service.model.UserFinancialDetail;
import com.namnp.portfolio_service.repository.UserRepository;
import com.namnp.portfolio_service.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements iUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public UserDTO findById(long id) {
        return userMapper.toDTO(userRepository.findById(id).orElse(new User()));
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User model = userMapper.toModel(userDTO, userRepository.findById(userDTO.getId()).orElse(new User()));
        if(model.getUserFinancialDetail() == null){
            model.setUserFinancialDetail(new UserFinancialDetail());
        }
        model.setPassword(encoder.encode(userDTO.getPassword()));
        return userMapper.toDTO(userRepository.save(model));
    }
}
