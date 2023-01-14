package com.trading.assignment.service;

import com.trading.assignment.model.PropertiesCountryCutoffTimes;

public interface CurrencyTradingService {
    String getCutoffTime(String currency1, String Currency2, String date);
}
