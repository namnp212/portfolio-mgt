package com.namnp.portfolio_service.controller;

import com.namnp.portfolio_service.dto.InvestmentDTO;
import com.namnp.portfolio_service.model.Investment;
import com.namnp.portfolio_service.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/investment")
public class InvestmentController {

    @Autowired
    InvestmentService investmentService;

    @GetMapping("get-all")
    public ResponseEntity<List<InvestmentDTO>> getAllInvestment(){
        return new ResponseEntity<>(investmentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<InvestmentDTO> createInvestment(@RequestBody InvestmentDTO investmentDTO){
        return new ResponseEntity(investmentService.saveInvestment(investmentDTO),HttpStatus.CREATED);
    }

    @PutMapping("edit")
    public ResponseEntity<InvestmentDTO> editInvestment(@RequestBody InvestmentDTO investmentDTO){
        return new ResponseEntity<>(investmentService.saveInvestment(investmentDTO),HttpStatus.OK);
    }
}
