package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.repository.AssetRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FundCertService {
    @Autowired
    AssetRepository assetRepository;
    public double getFundCertPrice(String symbol){
        try {
            String url = "https://fmarket.vn/quy/" + symbol;
            Document docFund = Jsoup.connect(url).get();
            String price = docFund.getElementsByClass("fund__intro fund__nav").select("span").get(1).text().replace(" VND", "").replace(",", "");
            return Double.parseDouble(price);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAsset(Asset item) {
        assetRepository.save(item);
    }

    public List<Asset> findAllFundCert() {
        return assetRepository.findByType(AssetType.FundCert);
    }
}
