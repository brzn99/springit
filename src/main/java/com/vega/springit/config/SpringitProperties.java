package com.vega.springit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "springit")
public class SpringitProperties
{
    /**
     * This is our welcome message
     */
    private String welcomeMsg="Hello from properties";
    public String getWelcomeMsg()
    {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg)
    {
        this.welcomeMsg = welcomeMsg;
    }
}
