package com.vega.springit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class DatabaseLoader implements CommandLineRunner
{
    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);
    @Override
    public void run(String... args) throws Exception
    {
        //do some database work
        log.info("Database loader ....");
    }

}
