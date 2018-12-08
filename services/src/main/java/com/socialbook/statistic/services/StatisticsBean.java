package com.socialbook.statistic.services;


import com.socialbook.statistic.entites.Statistic;
import com.socialbook.statistic.services.configuration.AppProperties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
public class StatisticsBean {
    private static final String TAG = StatisticsBean.class.getName();
    private Logger logger = Logger.getLogger(TAG);

    @PersistenceContext(unitName = "statistics-service-jpa")
    private EntityManager em;


    @PostConstruct
    private void init() {
        logger.info("Initialization of bean");
    }

    @PreDestroy
    private void closure() {
        logger.info("Destroying of bean");
    }

    @Inject
    AppProperties appProperties;

    public List<Statistic> getData() {
        return em.createNamedQuery("Stat.getAll").getResultList();
    }

    @Transactional
    public void insertStat(Statistic statistic) {
        logger.info("inserting new value");
        if (statistic != null) {
            logger.info("not null inserting");
            em.persist(statistic);
        }
    }

}
