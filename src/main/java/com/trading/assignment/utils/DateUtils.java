package com.trading.assignment.utils;

import com.trading.assignment.controller.CurrencyTradingController;
import com.trading.assignment.exception.InvalidParamException;
import com.trading.assignment.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@Component
public class DateUtils {
    private Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final String DATE_TODAY = "today";
    public static final String DATE_TOMORROW = "tomorrow";
    public static final String DATE_AFTER_TOMORROW = "after tomorrow";

    /**
     * Get the trade date window
     * @param date given date/trade date
     * @return Today, Tomorrow, after_tommorrow based on the given date
     */
    public String getTradeDateWindow(String date) {
        String dateWindow = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            LocalDate givenDate = LocalDate.parse(date,formatter);
            LocalDate today = LocalDate.now();
            LocalDate tomorrow = today.plusDays(1);

            if(givenDate.equals(today)){
                dateWindow = DATE_TODAY;
            }
            else if(givenDate.equals(tomorrow) ) {
                dateWindow = DATE_TOMORROW;
            }
            else if(givenDate.isAfter(tomorrow)) {
                dateWindow = DATE_AFTER_TOMORROW;
            }
        }catch (Exception e) {
            logger.debug("Not a valid date: " + date);
            throw new InvalidParamException("Cannot exchange based on the provided parameters or date format is not correct");
        }
        return dateWindow;
    }

    /**
     * Get local time based on the time string
     * @param time e.g., 09.00
     * @return LocalTime
     */
    public LocalTime getFormattedTime (String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
        return LocalTime.parse(time, formatter);
    }

    /**
     * Check if given time string is valid or not
     * @param time
     * @return true if time is valid string or false
     */
    public boolean isValidTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm");
        boolean isValidTime = false;
        try {
            LocalTime.parse(time, formatter);
            isValidTime = true;
        }catch (Exception e) {
            logger.debug("Not a valid time: " + time);
        }
        return isValidTime;
    }
}
