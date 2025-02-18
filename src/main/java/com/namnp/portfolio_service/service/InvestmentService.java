package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.dto.InvestmentDTO;
import com.namnp.portfolio_service.mapper.InvestmentMapper;
import com.namnp.portfolio_service.model.Investment;
import com.namnp.portfolio_service.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {
    @Autowired
    InvestmentRepository investmentRepository;

    @Autowired
    InvestmentMapper investmentMapper;

    public List<InvestmentDTO> findAll() { return investmentMapper.toDTO(investmentRepository.findAll());    }

    public InvestmentDTO saveInvestment(InvestmentDTO dto) {
        Investment toBeSave = investmentMapper.toInvestment(dto, investmentRepository.findById(dto.getId()).orElse(new Investment()));
        return investmentMapper.toDTO(investmentRepository.save(toBeSave));
    }
}
