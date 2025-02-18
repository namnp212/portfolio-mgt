package com.namnp.portfolio_service.mapper;

import com.namnp.portfolio_service.dto.InvestmentDTO;
import com.namnp.portfolio_service.model.Investment;
import com.namnp.portfolio_service.model.Portfolio;
import com.namnp.portfolio_service.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvestmentMapper {

    @Autowired
    AssetMapper assetMapper;

    public Investment toInvestment(InvestmentDTO dto, Investment investmentFromDB) {
        investmentFromDB.setEntry(dto.getEntry());
        investmentFromDB.setVolume(dto.getVolume());
        return investmentFromDB;
    }


    public InvestmentDTO toDTO (Investment investment){
        InvestmentDTO dto = new InvestmentDTO();
        dto.setId(investment.getId());
        dto.setEntry(investment.getEntry());
        dto.setVolume(investment.getVolume());
        dto.setAsset(assetMapper.toDTO(investment.getAsset()));
        return dto;
    }

    public List<InvestmentDTO> toDTO (List<Investment> investment){
        return investment.stream().map(item -> toDTO(item)).collect(Collectors.toList());
    }

//    public List<Investment> toInvestment(List<InvestmentDTO> investments) {
//
//    }
}
