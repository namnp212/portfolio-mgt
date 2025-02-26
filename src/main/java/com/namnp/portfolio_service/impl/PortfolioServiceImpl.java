package com.namnp.portfolio_service.impl;

import com.namnp.portfolio_service.dto.PortfolioDTO;
import com.namnp.portfolio_service.mapper.PortfolioMapper;
import com.namnp.portfolio_service.model.Portfolio;
import com.namnp.portfolio_service.repository.PortfolioRepository;
import com.namnp.portfolio_service.service.iPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioServiceImpl implements iPortfolioService {
    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    PortfolioMapper portfolioMapper;

    @Override
    public PortfolioDTO save(PortfolioDTO dto) {
        Portfolio portfolio = portfolioMapper.toModel(dto,portfolioRepository.findById(dto.getId()).orElse(new Portfolio()));
        return portfolioMapper.toDTO(portfolioRepository.save(portfolio));
    }

    @Override
    public List<PortfolioDTO> findAll() {
        return portfolioMapper.toDTO(portfolioRepository.findAll());
    }

    @Override
    public PortfolioDTO findById(long id) {
        return portfolioMapper.toDTO(portfolioRepository.findById(id).orElse(new Portfolio()));
    }
}
