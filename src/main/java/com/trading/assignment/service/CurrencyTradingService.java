package com.trading.assignment.service;

import com.trading.assignment.dto.CutoffTime;

public interface CurrencyTradingService {
    CutoffTime getCutoffTime(String currency1, String Currency2, String date);
}
