package com.namnp.portfolio_service.service;

import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StockService extends AssetService {

    @Override
    public double getPriceFromWeb(String symbol){
        try {
            String url = "https://24hmoney.vn/stock/" + symbol;
            Document doc = Jsoup.connect(url).get();
            Elements stockPrice = doc.getElementsByClass("price-detail").select("span");
            return Double.parseDouble(stockPrice.get(0).text());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Asset> findAllStocks() {
        return assetRepository.findByType(AssetType.Stock);
    }

}
