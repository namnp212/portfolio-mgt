package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.model.Investment;
import com.namnp.portfolio_service.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestmentService {
    @Autowired
    InvestmentRepository investmentRepository;

    public List<Investment> findAll() { return investmentRepository.findAll();    }

    public Investment saveInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }
}
