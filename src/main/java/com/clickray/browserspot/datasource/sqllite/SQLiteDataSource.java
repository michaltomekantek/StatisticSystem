package com.clickray.browserspot.datasource.sqllite;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "sqliteEntityManagerFactory",
        basePackages = { "com.clickray.browserspot.statisticsystem.sqlite" }
)
public class SQLiteDataSource {

    @Primary
    @Bean(name = "sqliteDataSource")
    @ConfigurationProperties(prefix = "spring.secondDatasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "sqliteEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("sqliteDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.clickray.browserspot.statisticsystem.model").persistenceUnit("datasource")
                .build();
    }

    @Primary
    @Bean(name = "sqLiteTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("sqliteEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
