package com.clickray.browserspot.statisticsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.clickray.browserspot.datasource.sqllite", "com.clickray.browserspot.datasource.mysql", "com.clickray.browserspot.statisticsystem", "com.clickray.browserspot.datasource.sqllite"})
public class StatisticSystem {
    public static void main(String[] args) {
        SpringApplication.run(StatisticSystem.class, args);
    }
}
