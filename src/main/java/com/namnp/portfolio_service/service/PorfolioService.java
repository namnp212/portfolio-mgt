package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.PortfolioDTO;
import com.namnp.portfolio_service.mapper.PortfolioMapper;
import com.namnp.portfolio_service.model.Portfolio;
import com.namnp.portfolio_service.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorfolioService {
    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    PortfolioMapper portfolioMapper;

    public PortfolioDTO savePortfolio(PortfolioDTO dto) {
        Portfolio portfolio = portfolioMapper.toPortfolio(dto,portfolioRepository.findById(dto.getId()).orElse(new Portfolio()));
        return portfolioMapper.toDTO(portfolioRepository.save(portfolio));
    }

    public List<PortfolioDTO> findAll() {
        return portfolioMapper.toDTO(portfolioRepository.findAll());
    }
}
