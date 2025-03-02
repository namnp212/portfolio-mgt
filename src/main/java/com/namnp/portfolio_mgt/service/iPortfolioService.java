package com.namnp.portfolio_mgt.service;

import com.namnp.portfolio_mgt.dto.PortfolioDTO;

import java.util.List;

public interface iPortfolioService {

    public PortfolioDTO save(PortfolioDTO dto);
    public List<PortfolioDTO> findAll();
    public PortfolioDTO findById(long id);
}
