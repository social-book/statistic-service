package com.socialbook.statistic.services.configuration;

import com.kumuluz.ee.configuration.cdi.ConfigBundle;
import com.kumuluz.ee.configuration.cdi.ConfigValue;

import javax.enterprise.context.RequestScoped;
//import org.glassfish.jersey.process.internal.RequestScoped;


@RequestScoped
@ConfigBundle("app-properties")
public class AppProperties {
    @ConfigValue(value = "external-service.enabled")
    private boolean externalServiceEnabled;

    public boolean isExternalServiceEnabled() {
        return externalServiceEnabled;
    }

    public void setExternalServiceEnabled(boolean externalServiceEnabled) {
        this.externalServiceEnabled = externalServiceEnabled;
    }
}
