package com.trading.assignment.service.impl;

import com.trading.assignment.dao.CurrencyTradingRepository;
import com.trading.assignment.dto.CutoffTime;
import com.trading.assignment.exception.IsoNotFoundException;
import com.trading.assignment.model.PropertiesCountryCutoffTimes;
import com.trading.assignment.service.CurrencyTradingService;
import com.trading.assignment.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyTradingServiceImpl implements CurrencyTradingService {
    private Logger logger = LoggerFactory.getLogger(CurrencyTradingServiceImpl.class);
    public static final String CUTOFF_TIME_NEVER = "Never possible";
    public static final String CUTOFF_TIME_ALWAYS = "Always possible";

    @Autowired
    CurrencyTradingRepository tradingRepository;

    @Autowired
    DateUtils dateUtils;

    public CutoffTime getCutoffTime(String currency1, String currency2, String tradeDate) {
        String resultCutoffTime = "";
        PropertiesCountryCutoffTimes properties1 = null;
        PropertiesCountryCutoffTimes properties2 = null;

        boolean propertyNotFound = false;
        try {
            properties1 = tradingRepository.findByIso(currency1);
            properties2 = tradingRepository.findByIso(currency2);
        }catch (Exception exe) {
            propertyNotFound = true;
            logger.error("Exception while fetching the properties with currencies {} and {}", currency1, currency2);
        }

        if(propertyNotFound){
            throw new IsoNotFoundException("Cannot exchange based on the provided parameters");
        }

        String dateWindow = dateUtils.getTradeDateWindow(tradeDate);

        switch (dateWindow) {
            case DateUtils.DATE_TODAY:
                resultCutoffTime = getFinalCutoffTime(properties1.getCutoffTimeToday(), properties2.getCutoffTimeToday());
                break;
            case DateUtils.DATE_TOMORROW:
                resultCutoffTime = getFinalCutoffTime(properties1.getCutoffTimeTomorrow(), properties2.getCutoffTimeTomorrow());
                break;
            case DateUtils.DATE_AFTER_TOMORROW:
                resultCutoffTime = getFinalCutoffTime(properties1.getCutoffTimeAfterTomorrow(), properties2.getCutoffTimeAfterTomorrow());
                break;
        }
        CutoffTime cutoffTime = new CutoffTime();
        cutoffTime.setCurrency1(currency1);
        cutoffTime.setCurrency2(currency2);
        cutoffTime.setCutoffTime(resultCutoffTime);
        return cutoffTime;
    }

    private String getFinalCutoffTime(String time1, String time2) {
        String cutoff = "";
        if(dateUtils.isValidTime(time1) && dateUtils.isValidTime(time2)) {
            if(dateUtils.getFormattedTime(time1).isBefore(dateUtils.getFormattedTime(time2))) {
                cutoff = time1;
            }else {
                cutoff = time2;
            }
        }
        else if(dateUtils.isValidTime(time1) || dateUtils.isValidTime(time2)) {
            if((!dateUtils.isValidTime(time1) && time1.equalsIgnoreCase(CUTOFF_TIME_NEVER))
                    || (!dateUtils.isValidTime(time2) && time2.equalsIgnoreCase(CUTOFF_TIME_NEVER))){
                cutoff = CUTOFF_TIME_NEVER;
            }
            else if((!dateUtils.isValidTime(time1) && time1.equalsIgnoreCase(CUTOFF_TIME_ALWAYS))
                    || (!dateUtils.isValidTime(time2) && time2.equalsIgnoreCase(CUTOFF_TIME_ALWAYS))){
                if(dateUtils.isValidTime(time1)){
                    cutoff = time1;
                }else {
                    cutoff = time2;
                }
            }
        }
        else {
            if(time1.equalsIgnoreCase(CUTOFF_TIME_NEVER) || time2.equalsIgnoreCase(CUTOFF_TIME_NEVER)){
                cutoff = CUTOFF_TIME_NEVER;
            }else {
                cutoff = CUTOFF_TIME_ALWAYS;
            }
        }
        return cutoff;
    }
}
