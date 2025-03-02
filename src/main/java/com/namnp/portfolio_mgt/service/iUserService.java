package com.namnp.portfolio_mgt.service;

import com.namnp.portfolio_mgt.dto.UserDTO;

public interface iUserService {
    public UserDTO findById(long id);
    public UserDTO save(UserDTO userDTO);
    public String authenticate(UserDTO userDTO);
}
