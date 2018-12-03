package com.socialbook.statistic.services;


import com.socialbook.statistic.entites.Statistic;
import com.socialbook.statistic.services.configuration.AppProperties;
//import org.glassfish.jersey.process.internal.RequestScoped;

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
public class StatisticBean {
    private static final String TAG = StatisticBean.class.getName();
    private Logger logger = Logger.getLogger(TAG);

    @PersistenceContext(unitName = "statistic-service-jpa")
    private EntityManager entityManager;


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

    @Transactional
    public List<Statistic> getData() {
        return entityManager.createNamedQuery("Stat.getAll").getResultList();
    }

    @Transactional
    public void insertStat(Statistic statistic) {
        logger.info("inserting new value");
        if (statistic != null) {
            logger.info("not null inserting");
            entityManager.persist(statistic);
        }
    }

}
