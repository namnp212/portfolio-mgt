package com.namnp.portfolio_service.scheduler;

import com.namnp.portfolio_service.dto.AssetDTO;
import com.namnp.portfolio_service.model.Asset;
import com.namnp.portfolio_service.model.AssetType;
import com.namnp.portfolio_service.service.CryptoService;
import com.namnp.portfolio_service.service.FundCertService;
import com.namnp.portfolio_service.service.GoldService;
import com.namnp.portfolio_service.service.StockService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Scheduler {

    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);

    @Autowired
    GoldService goldService;

    @Autowired
    StockService stockService;

    @Autowired
    CryptoService cryptoService;

    @Autowired
    FundCertService fundCertService;

    @Scheduled(cron = "0 0/15 * * * *") //every 15 minutes
//    @Scheduled(cron = "0/5 * * * * *") //dev only

    public void updateGoldPrice() {
        log.info("===============================Fetch Gold start===============================");

        try {
            Document docGold = Jsoup.connect("https://giavang.org/trong-nuoc/doji/").get();
            Elements goldPrice = docGold.getElementsByClass("gold-price");
            Element sjcBuy = goldPrice.get(1);
            sjcBuy.select("small").remove();

            Element sjcSell = goldPrice.get(0);
            sjcSell.select("small").remove();

            AssetDTO sjcBar = goldService.getGoldBySymbol("sjc-bar");
            if (sjcBar.getSymbol() == null || sjcBar.getSymbol().isEmpty()) {
                sjcBar.setName("SJC Gold");
                sjcBar.setSymbol("sjc-bar");
                sjcBar.setType(AssetType.Gold.toString());
            }
            sjcBar.setBuyPrice(Double.parseDouble(sjcBuy.text()));
            sjcBar.setSellPrice(Double.parseDouble(sjcSell.text()));
            goldService.saveAsset(sjcBar);

            Element dojiBuy = goldPrice.get(3);
            dojiBuy.select("small").remove();

            Element dojiSell = goldPrice.get(2);
            dojiSell.select("small").remove();

            AssetDTO dojiRing = goldService.getGoldBySymbol("doji-ring");
            if (dojiRing.getSymbol() == null || dojiRing.getSymbol().isEmpty()) {
                dojiRing.setName("DOJI Gold");
                dojiRing.setSymbol("doji-ring");
                dojiRing.setType(AssetType.Gold.toString());
            }
            dojiRing.setBuyPrice(Double.parseDouble(dojiBuy.text()));
            dojiRing.setSellPrice(Double.parseDouble(dojiSell.text()));
            goldService.saveAsset(dojiRing);

        } catch (Exception e) {
            log.error("Uncovered. Something wrong with gold. Please check!");
        }
        log.info("===============================Fetch Gold end===============================");
    }

        @Scheduled(cron = "0 0/10 * * * *") //every 10 minutes
//    @Scheduled(cron = "0/5 * * * * *") //dev only
    public void updateStockPrice() {
        log.info("===============================Fetch Stock start===============================");
        List<AssetDTO> stockList = stockService.findAllStocks();

        for (AssetDTO item : stockList) {
            double newPrice = stockService.getPriceFromWeb(item.getSymbol());
            item.setBuyPrice(newPrice);
            item.setSellPrice(newPrice);
            stockService.saveAsset(item);
        }
        log.info("===============================Fetch Stock end===============================");
    }

    @Scheduled(cron = "0 0/5 * * * *") //every 5 minutes
//    @Scheduled(cron = "0/5 * * * * *") //dev only

    public void updateCryptoPrice() {
        log.info("===============================Fetch Crypto start===============================");
        List<AssetDTO> cryptoList = cryptoService.findAllCryptos();

        for (AssetDTO item : cryptoList) {
            double newPrice = cryptoService.getPriceFromWeb(item.getSymbol());
            item.setBuyPrice(newPrice);
            item.setSellPrice(newPrice);
            cryptoService.saveAsset(item);
        }
        log.info("===============================Fetch Crypto end===============================");
    }

        @Scheduled(cron = "0 0 15 * * *") //everyday at 15:00
//    @Scheduled(cron = "0/5 * * * * *") //dev only
    public void updateFundCertPrice() {
        log.info("===============================Fetch Fund Cert start===============================");
        List<AssetDTO> fundCertList = fundCertService.findAllFundCert();

        for (AssetDTO item : fundCertList) {
            double newPrice = fundCertService.getPriceFromWeb(item.getSymbol());
            item.setBuyPrice(newPrice);
            item.setSellPrice(newPrice);
            fundCertService.saveAsset(item);
        }
        log.info("===============================Fetch Fund Cert start===============================");
    }




}
