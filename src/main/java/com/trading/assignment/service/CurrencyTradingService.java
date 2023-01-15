package com.trading.assignment.service;

import com.trading.assignment.dto.CutoffTime;

public interface CurrencyTradingService {
    /**
     * Get the cutoff time
     * @param currency1 currency of country1 e.g., DKK
     * @param Currency2 currency of country2 e.g., USD
     * @param date Given date for the trade, e.g., dd-MM-yyyy
     * @return CutoffTime
     */
    CutoffTime getCutoffTime(String currency1, String Currency2, String date);
}
