package com.namnp.portfolio_service.controller;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.mapper.AssetMapper;
import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/asset")
public class AssetController {

    @Autowired
    AssetService assetService;

    @Autowired
    AssetMapper assetMapper;

    @GetMapping("/get-all")
    public ResponseEntity<List<Asset>> getAllGoldPrice(){
        return new ResponseEntity<>(assetService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Asset> createAsset(@RequestBody Asset asset){
        return new ResponseEntity(assetService.saveAsset(asset),HttpStatus.CREATED);
    }

    @PostMapping("/edit")
    public ResponseEntity<Asset> editAsset(@RequestBody AssetDTO dto){
        Asset asset  = assetMapper.toAsset(dto, assetService.findById(dto.getId()));
        //                                 DTO        Asset model from DB
        return new ResponseEntity(assetService.saveAsset(asset),HttpStatus.OK);
    }
}
