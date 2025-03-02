package com.namnp.portfolio_mgt.mapper;

import com.namnp.portfolio_mgt.dto.UserFinancialDetailDTO;
import com.namnp.portfolio_mgt.model.Portfolio;
import com.namnp.portfolio_mgt.model.UserFinancialDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserFinancialDetailMapper {

    @Autowired
    PortfolioMapper portfolioMapper;

    public UserFinancialDetail toModel(UserFinancialDetailDTO dto, UserFinancialDetail fromDB){
        fromDB.setCash(dto.getCash());
        return fromDB;
    }

    public UserFinancialDetailDTO toDTO(UserFinancialDetail model){
        UserFinancialDetailDTO dto = new UserFinancialDetailDTO();
        dto.setId(model.getId());
        dto.setCash(model.getCash());
        List<Portfolio> list = model.getPortfolios() != null ? model.getPortfolios() : new ArrayList<Portfolio>();
        dto.setPortfolios(portfolioMapper.toDTO(list));

        return dto;
    }
}
