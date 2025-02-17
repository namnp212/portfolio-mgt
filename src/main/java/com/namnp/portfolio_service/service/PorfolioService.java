package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.model.Portfolio;
import com.namnp.portfolio_service.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PorfolioService {
    @Autowired
    PortfolioRepository portfolioRepository;


    public Portfolio savePortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> findAll() {
        return portfolioRepository.findAll();
    }
}
