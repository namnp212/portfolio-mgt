package com.namnp.portfolio_service.controller;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetController {

    @Autowired
    AssetService assetService;

    @GetMapping("/getAllGold")
    public ResponseEntity<List<Asset>> getAllGoldPrice(){
        return new ResponseEntity<>(assetService.findByType(AssetType.Gold), HttpStatus.OK);
    }

    @PostMapping("/asset")
    public ResponseEntity createAsset(@RequestBody Asset asset){
        assetService.saveAsset(asset);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
