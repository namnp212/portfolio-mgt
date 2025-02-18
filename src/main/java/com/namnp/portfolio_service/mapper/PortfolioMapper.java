package com.namnp.portfolio_service.mapper;

import com.namnp.portfolio_service.dto.InvestmentDTO;
import com.namnp.portfolio_service.dto.PortfolioDTO;
import com.namnp.portfolio_service.model.Investment;
import com.namnp.portfolio_service.model.Portfolio;
import com.namnp.portfolio_service.model.PortfolioRiskLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PortfolioMapper {

    @Autowired
    InvestmentMapper investmentMapper;


    public Portfolio toPortfolio(PortfolioDTO dto, Portfolio portfolioFromDB){
        portfolioFromDB.setId(dto.getId());
        portfolioFromDB.setName(dto.getName());
        portfolioFromDB.setRiskLevel(PortfolioRiskLevel.valueOf(dto.getRiskLevel()));
        //portfolioFromDB.setInvestments(investmentMapper.toInvestment(dto.getInvestments()));
        return portfolioFromDB;
    }

    public PortfolioDTO toDTO(Portfolio portfolio){
        PortfolioDTO dto = new PortfolioDTO();
        dto.setId(portfolio.getId());
        dto.setName(portfolio.getName());
        dto.setRiskLevel(portfolio.getRiskLevel().toString());
        List<Investment> investmentList = portfolio.getInvestments() != null ? portfolio.getInvestments() : new ArrayList<>();
        dto.setInvestments(investmentMapper.toDTO(investmentList));
        return dto;
    }

    public List<PortfolioDTO> toDTO(List<Portfolio> dtoList) {
        return dtoList.stream().map(item -> toDTO(item)).collect(Collectors.toList());
    }
}
