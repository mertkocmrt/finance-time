package com.finance.time;

import com.finance.time.controllers.ExchangeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExchangeApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ExchangeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExchangeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Exchange App starts...");
    }
}
