package com.trading.assignment.dao;

import com.trading.assignment.model.PropertiesCountryCutoffTimes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyTradingRepository extends JpaRepository<PropertiesCountryCutoffTimes, Long> {
    PropertiesCountryCutoffTimes findByIso(String iso);
}
