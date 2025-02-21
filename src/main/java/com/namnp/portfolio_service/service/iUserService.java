package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.UserDTO;

public interface iUserService {
    public UserDTO findById(long id);
}
