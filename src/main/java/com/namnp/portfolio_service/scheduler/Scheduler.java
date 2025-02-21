package com.namnp.portfolio_service.scheduler;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.service.*;
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


    @Scheduled(cron = "0 */15 7-20 * * 1-5", zone = "Asia/Saigon") //every 15 minutes
//  @Scheduled(cron = "0/5 * * * * *") //dev only
    public void updateGoldPrice() {
        try {
            Document docGold = Jsoup.connect("https://giavang.org/trong-nuoc/doji/").get();
            Elements goldPrice = docGold.getElementsByClass("gold-price");
            Element sjcBuy = goldPrice.get(1);
            sjcBuy.select("small").remove();

            Element sjcSell = goldPrice.get(0);
            sjcSell.select("small").remove();

            AssetDTO sjcBar = assetServiceImpl.getGoldBySymbol("sjc-bar");
            if (sjcBar.getSymbol() == null || sjcBar.getSymbol().isEmpty()) {
                sjcBar.setName("SJC Gold");
                sjcBar.setSymbol("sjc-bar");
                sjcBar.setType(AssetType.Gold.toString());
            }
            sjcBar.setBuyPrice(Double.parseDouble(sjcBuy.text()));
            sjcBar.setSellPrice(Double.parseDouble(sjcSell.text()));
            assetServiceImpl.saveAsset(sjcBar);

            Element dojiBuy = goldPrice.get(3);
            dojiBuy.select("small").remove();

            Element dojiSell = goldPrice.get(2);
            dojiSell.select("small").remove();

            AssetDTO dojiRing = assetServiceImpl.getGoldBySymbol("doji-ring");
            if (dojiRing.getSymbol() == null || dojiRing.getSymbol().isEmpty()) {
                dojiRing.setName("DOJI Gold");
                dojiRing.setSymbol("doji-ring");
                dojiRing.setType(AssetType.Gold.toString());
            }
            dojiRing.setBuyPrice(Double.parseDouble(dojiBuy.text()));
            dojiRing.setSellPrice(Double.parseDouble(dojiSell.text()));
            assetServiceImpl.saveAsset(dojiRing);

        } catch (Exception e) {
            log.error("Uncovered. Something wrong with gold. Please check!");
        }
    }

    @Scheduled(cron = "0 */10 9-15 * * 1-5", zone = "Asia/Saigon") //every 10 minutes
//  @Scheduled(cron = "*/5 * * * * *") //dev only
    public void updateStockPrice() {
        List<AssetDTO> stockList = assetServiceImpl.findAllStocks();

        for (AssetDTO item : stockList) {
            double newPrice = DataCrawler.getPriceFromWeb(item.getSymbol(), AssetType.valueOf(item.getType()));
            item.setBuyPrice(newPrice);
            item.setSellPrice(newPrice);
            assetServiceImpl.saveAsset(item);
        }
    }

    @Scheduled(cron = "0 */5 * * * *") //every 5 minutes
//    @Scheduled(cron = "*/5 * * * * *") //dev only
    public void updateCryptoPrice() {
        List<AssetDTO> cryptoList = assetServiceImpl.findAllCrypto();

        for (AssetDTO item : cryptoList) {
            double newPrice = DataCrawler.getPriceFromWeb(item.getSymbol(), AssetType.valueOf(item.getType()));
            item.setBuyPrice(newPrice);
            item.setSellPrice(newPrice);
            assetServiceImpl.saveAsset(item);
        }
    }

    @Scheduled(cron = "0 */30 15-17 * * 1-5", zone = "Asia/Saigon") //everyday at 15:00
//  @Scheduled(cron = "0/5 * * * * *") //dev only
    public void updateFundCertPrice() {
        List<AssetDTO> fundCertList = assetServiceImpl.findAllFundCert();

        for (AssetDTO item : fundCertList) {
            double newPrice = DataCrawler.getPriceFromWeb(item.getSymbol(), AssetType.valueOf(item.getType()));
            item.setBuyPrice(newPrice);
            item.setSellPrice(newPrice);
            assetServiceImpl.saveAsset(item);
        }
    }
}
