CREATE TABLE PROPERTIES_COUNTRY_CUTOFF_TIMES (
       id int NOT NULL AUTO_INCREMENT(1001),
       iso ENUM('AED','AUD','BGN','CAD','CHF','CNH','CZK','DKK','EUR','GBP','HKD','HRK','HUF','ILS','JPY','MXN','NOK','NZD','PLN','RON','RUB','RSD','SAR','SEK','SGD','THB','TRY','USD','ZAR') NOT NULL,
       country varchar(50) NOT NULL,
       cutoff_time_today ENUM('Never possible','Always possible','09.00','10.00', '11.00', '13.00', '14.00','15.00', '15.30', '16.00') NULL DEFAULT NULL,
       cutoff_time_tomorrow ENUM('Never possible','Always possible','09.00','10.00', '11.00', '13.00', '14.00','15.00', '15.30', '16.00') NULL DEFAULT NULL,
       cutoff_time_after_tomorrow ENUM('Never possible','Always possible','09.00','10.00', '11.00', '13.00', '14.00','15.00', '15.30', '16.00') NULL DEFAULT NULL,
       PRIMARY KEY (id)
);