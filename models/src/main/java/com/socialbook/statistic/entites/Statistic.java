package com.socialbook.statistic.entites;

import javax.persistence.*;

@Entity(name = "statistic_table")
@NamedQueries(value = {
        @NamedQuery(name = "Stat.getAll", query = "SELECT st FROM statistic_table st")
})
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stat_id")
    private Integer stat_id;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "request_from")
    private String request_from;

    @Column(name = "request_to")
    private String request_to;


    public Integer getStat_id() {
        return stat_id;
    }

    public void setStat_id(Integer stat_id) {
        this.stat_id = stat_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRequest_from() {
        return request_from;
    }

    public void setRequest_from(String request_from) {
        this.request_from = request_from;
    }

    public String getRequest_to() {
        return request_to;
    }

    public void setRequest_to(String request_to) {
        this.request_to = request_to;
    }
}
