package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.PortfolioDTO;

import java.util.List;

public interface iPortfolioService {

    public PortfolioDTO savePortfolio(PortfolioDTO dto);
    public List<PortfolioDTO> findAll();
    public PortfolioDTO findById(long id);
}
