package com.namnp.portfolio_service.controller;

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
    public ResponseEntity<List<Investment>> getAllInvestment(){
        return new ResponseEntity<>(investmentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment){
        return new ResponseEntity(investmentService.saveInvestment(investment),HttpStatus.CREATED);
    }
}
