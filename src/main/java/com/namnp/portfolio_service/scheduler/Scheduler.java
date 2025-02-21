package com.namnp.portfolio_service.scheduler;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.impl.AssetServiceImpl;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.util.DataCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Scheduler {

    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

    @Autowired
    AssetServiceImpl assetServiceImpl;


//    @Scheduled(cron = "0 */15 7-20 * * 1-5", zone = "Asia/Saigon") //every 15 minutes
    @Scheduled(cron = "0/5 * * * * *") //dev only
    public void updateGoldPrice() {
        List<AssetDTO> goldList = assetServiceImpl.findALlGold();

        for (AssetDTO item : goldList) {
            double[] newPrice = DataCrawler.getPriceFromWeb(item.getSymbol(), AssetType.valueOf(item.getType()));
            item.setBuyPrice(newPrice[0]);
            item.setSellPrice(newPrice[1]);
            assetServiceImpl.save(item);
        }
    }

    @Scheduled(cron = "0 */10 9-15 * * 1-5", zone = "Asia/Saigon") //every 10 minutes
//    @Scheduled(cron = "*/5 * * * * *") //dev only
    public void updateStockPrice() {
        List<AssetDTO> stockList = assetServiceImpl.findAllStocks();

        for (AssetDTO item : stockList) {
            double[] newPrice = DataCrawler.getPriceFromWeb(item.getSymbol(), AssetType.valueOf(item.getType()));
            item.setBuyPrice(newPrice[0]);
            item.setSellPrice(newPrice[1]);
            assetServiceImpl.save(item);
        }
    }

    @Scheduled(cron = "0 */5 * * * *") //every 5 minutes
//    @Scheduled(cron = "*/5 * * * * *") //dev only
    public void updateCryptoPrice() {
        List<AssetDTO> cryptoList = assetServiceImpl.findAllCrypto();

        for (AssetDTO item : cryptoList) {
            double[] newPrice = DataCrawler.getPriceFromWeb(item.getSymbol(), AssetType.valueOf(item.getType()));
            item.setBuyPrice(newPrice[0]);
            item.setSellPrice(newPrice[1]);
            assetServiceImpl.save(item);
        }
    }

    @Scheduled(cron = "0 */30 15-17 * * 1-5", zone = "Asia/Saigon") //everyday at 15:00
//    @Scheduled(cron = "0/5 * * * * *") //dev only
    public void updateFundCertPrice() {
        List<AssetDTO> fundCertList = assetServiceImpl.findAllFundCert();

        for (AssetDTO item : fundCertList) {
            double[] newPrice = DataCrawler.getPriceFromWeb(item.getSymbol(), AssetType.valueOf(item.getType()));
            item.setBuyPrice(newPrice[0]);
            item.setSellPrice(newPrice[1]);
            assetServiceImpl.save(item);
        }
    }
}
