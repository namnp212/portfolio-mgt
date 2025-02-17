package com.namnp.portfolio_service.mapper;

import com.namnp.portfolio_service.dto.PortfolioDTO;
import com.namnp.portfolio_service.model.Portfolio;
import com.namnp.portfolio_service.model.PortfolioRiskLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMapper {

    @Autowired
    InvestmentMapper investmentMapper;

    public Portfolio toPortfolio(PortfolioDTO dto){
        Portfolio portfolio = new Portfolio();
        portfolio.setId(dto.getId());
        portfolio.setName(dto.getName());
        portfolio.setRiskLevel(PortfolioRiskLevel.valueOf(dto.getRiskLevel()));
        //portfolio.setInvestments(investmentMapper.toInvestment(dto.getInvestments()));
        return portfolio;
    }
    public Portfolio toPortfolio(PortfolioDTO dto, Portfolio portfolioFromDB){
        portfolioFromDB.setName(dto.getName());
        portfolioFromDB.setRiskLevel(PortfolioRiskLevel.valueOf(dto.getRiskLevel()));
        return portfolioFromDB;
    }
}
