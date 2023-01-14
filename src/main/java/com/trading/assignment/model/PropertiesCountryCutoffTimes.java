package com.trading.assignment.model;

import javax.persistence.*;

@Entity
@Cacheable
@Table(name="PROPERTIES_COUNTRY_CUTOFF_TIMES")
public class PropertiesCountryCutoffTimes {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "iso")
    private String iso;
    @Column(name = "country")
    private String country;
    @Column(name = "cutoff_time_today")
    private String cutoffTimeToday;
    @Column(name = "cutoff_time_tomorrow")
    private String cutoffTimeTomorrow;
    @Column(name = "cutoff_time_after_tomorrow")
    private String cutoffTimeAfterTomorrow;

    public PropertiesCountryCutoffTimes() {

    }

    public PropertiesCountryCutoffTimes(Long id, String iso, String country, String cutoffTimeToday, String cutoffTimeTomorrow, String cutoffTimeAfterTomorrow) {
        this.id = id;
        this.iso = iso;
        this.country = country;
        this.cutoffTimeToday = cutoffTimeToday;
        this.cutoffTimeTomorrow = cutoffTimeTomorrow;
        this.cutoffTimeAfterTomorrow = cutoffTimeAfterTomorrow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCutoffTimeToday() {
        return cutoffTimeToday;
    }

    public void setCutoffTimeToday(String cutoffTimeToday) {
        this.cutoffTimeToday = cutoffTimeToday;
    }

    public String getCutoffTimeTomorrow() {
        return cutoffTimeTomorrow;
    }

    public void setCutoffTimeTomorrow(String cutoffTimeTomorrow) {
        this.cutoffTimeTomorrow = cutoffTimeTomorrow;
    }

    public String getCutoffTimeAfterTomorrow() {
        return cutoffTimeAfterTomorrow;
    }

    public void setCutoffTimeAfterTomorrow(String cutoffTimeAfterTomorrow) {
        this.cutoffTimeAfterTomorrow = cutoffTimeAfterTomorrow;
    }
}
