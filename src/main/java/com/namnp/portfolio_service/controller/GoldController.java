package com.namnp.portfolio_service.controller;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoldController {

    @Autowired
    GoldService goldService;

    @RequestMapping("/getAll")
    public List<Asset> getAllGoldPrice(){
        return goldService.getAll();
    }
}
