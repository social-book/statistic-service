package com.socialbook.statistic.entites;

import javax.persistence.*;

@Entity(name = "statistic_table")
@NamedQueries(value = {@NamedQuery(name = "Stat.getAll", query = "SELECT st FROM statistic_table st")})
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statId;

    @Column(name = "timestamp")
    private String timeStamp;

    @Column(name = "request_from")
    private String requestFromUrl;

    @Column(name = "request_to")
    private String requestToUrl;

    public Integer getStatId() {
        return statId;
    }

    public void setStatId(Integer statId) {
        this.statId = statId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getRequestFromUrl() {
        return requestFromUrl;
    }

    public void setRequestFromUrl(String requestFromUrl) {
        this.requestFromUrl = requestFromUrl;
    }

    public String getRequestToUrl() {
        return requestToUrl;
    }

    public void setRequestToUrl(String requestToUrl) {
        this.requestToUrl = requestToUrl;
    }
}
