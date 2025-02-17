package com.namnp.portfolio_service.mapper;

import com.namnp.portfolio_service.dto.InvestmentDTO;
import com.namnp.portfolio_service.model.Investment;

import java.util.List;

public class InvestmentMapper {

    public Investment toInvestment(InvestmentDTO dto, Investment investmentFromDB) {
        investmentFromDB.setEntry(dto.getEntry());
        investmentFromDB.setVolume(dto.getVolume());
        return investmentFromDB;
    }
//    public List<Investment> toInvestment(List<InvestmentDTO> investments) {
//
//    }
}
