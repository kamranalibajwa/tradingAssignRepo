package com.trading.assignment.controller;

import com.trading.assignment.dto.CutoffTime;
import com.trading.assignment.exception.IsoNotFoundException;
import com.trading.assignment.service.impl.CurrencyTradingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyTradingController {
    private Logger logger = LoggerFactory.getLogger(CurrencyTradingController.class);

    @Autowired
    CurrencyTradingServiceImpl tradingService;

    @GetMapping("/get-cutoff-time")
    public CutoffTime retrieveCutoffTime(@RequestParam("currency1") String currency1,
                                         @RequestParam("currency2") String currency2,
                                         @RequestParam("tradeDate") String tradeDate){
        logger.info("retrieveCutoffTime is called with currencies {} , {} for date: {}", currency1, currency2, tradeDate);

        if("cutoffTime" == null) {
            throw new IsoNotFoundException("Unable to find data for xxx");
        }

        return tradingService.getCutoffTime(currency1, currency2, tradeDate);
    }
}
