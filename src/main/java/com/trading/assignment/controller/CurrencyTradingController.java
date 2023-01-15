package com.trading.assignment.controller;

import com.trading.assignment.dto.CutoffTime;
import com.trading.assignment.exception.IsoNotFoundException;
import com.trading.assignment.service.impl.CurrencyTradingServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(
        info = @Info(
                title = "Currency Trade API",
                version = "1.0",
                description = "Currency trade api provides cutoff time in order to trade two currencies based on the provided currencies and given time"
        )
)
@RestController
public class CurrencyTradingController {
    private Logger logger = LoggerFactory.getLogger(CurrencyTradingController.class);

    @Autowired
    CurrencyTradingServiceImpl tradingService;

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retrieved cutoff time successfully"),
            @ApiResponse(responseCode = "400", description = "Parameters are not correct"),
            @ApiResponse(responseCode = "404", description = "Currencies are not found")
    })
    @GetMapping("/get-cutoff-time")
    public CutoffTime retrieveCutoffTime(@Parameter(required = true, description = "Currency code for country1, e.g., USD")
                                         @RequestParam("currency1") String currency1,
                                         @Parameter(required = true, description = "Currency code for country2, e.g., DKK")
                                         @RequestParam("currency2") String currency2,
                                         @Parameter(required = true, description = "Given date for the trade, e.g., dd-MM-yyyy, 16-01-2023")
                                         @RequestParam("tradeDate") String tradeDate){
        logger.info("retrieveCutoffTime is called with currencies {} , {} for date: {}", currency1, currency2, tradeDate);

        return tradingService.getCutoffTime(currency1, currency2, tradeDate);
    }
}
