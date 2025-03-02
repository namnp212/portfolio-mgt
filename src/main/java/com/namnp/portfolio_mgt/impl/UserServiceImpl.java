package com.namnp.portfolio_mgt.impl;

import com.namnp.portfolio_mgt.dto.UserDTO;
import com.namnp.portfolio_mgt.mapper.UserMapper;
import com.namnp.portfolio_mgt.model.User;
import com.namnp.portfolio_mgt.model.UserFinancialDetail;
import com.namnp.portfolio_mgt.repository.UserRepository;
import com.namnp.portfolio_mgt.service.JwtService;
import com.namnp.portfolio_mgt.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements iUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

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

    @Override
    public String authenticate(UserDTO userDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUserName(), userDTO.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(userDTO.getUserName());
        }
        return "Access Denied";
    }
}
