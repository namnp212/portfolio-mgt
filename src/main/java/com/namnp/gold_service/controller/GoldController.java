package com.namnp.gold_service.controller;

import com.namnp.gold_service.repository.GoldRepository;
import com.namnp.gold_service.model.GoldPrice;
import com.namnp.gold_service.service.GoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoldController {

    @Autowired
    GoldService goldService;

    @RequestMapping("/get")
    public List<GoldPrice> getAllGoldPrice(){
        return goldService.getAll();
    }
}
