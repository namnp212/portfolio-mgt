package com.namnp.portfolio_service.mapper;

import com.namnp.portfolio_service.dto.UserDTO;
import com.namnp.portfolio_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    UserFinancialDetailMapper userFinancialDetailMapper;

    public User toModel(UserDTO dto, User fromDB){
        fromDB.setFirstName(dto.getFirstName());
        fromDB.setLastName(dto.getLastName());
        fromDB.setEmail(dto.getEmail());
        fromDB.setPassword(dto.getPassword());
        return fromDB;
    }

    public UserDTO toDTO(User model){
        UserDTO dto = new UserDTO();
        dto.setId(model.getId());
        dto.setUserName(model.getUserName());
        dto.setEmail(model.getEmail());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setUserFinancialInfo(userFinancialDetailMapper.toDTO(model.getUserFinancialDetail()));
        return dto;
    }

}
