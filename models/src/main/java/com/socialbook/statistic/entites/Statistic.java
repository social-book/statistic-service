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

    @Column(name = "service_name")
    private String service_name;


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

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }
}
