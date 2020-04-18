package com.vega.springit;

import com.vega.springit.config.SpringitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
@ConfigurationPropertiesScan("com.vega.springit.config")
public class SpringitApplication
{

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);
    @Autowired
    private SpringitProperties springitProperties;
    @Autowired
    private ApplicationContext applicationContext;
    public static void main(String[] args)
    {
        SpringApplication.run(SpringitApplication.class, args);
        log.info("Hello from the LOGGER");
    }

    @Bean
    @Profile("dev")
    CommandLineRunner runner ()
    {
        return args ->
        {
            log.info("Welcome Message="+springitProperties.getWelcomeMsg());
            String[] beans=applicationContext.getBeanDefinitionNames();
            //Arrays.stream(beans).forEach(bean -> System.out.println(bean));
        };
    }

}
