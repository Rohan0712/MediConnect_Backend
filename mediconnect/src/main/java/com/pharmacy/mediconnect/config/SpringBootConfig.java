package com.pharmacy.mediconnect.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "pharmacyEntityManagerFactory",
        transactionManagerRef = "pharmacyTransactionManager",
        basePackages = {"com.pharmacy.mediconnect"}
)
public class SpringBootConfig {
	
	@Primary
    @Bean(name = "pharmacyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource pharmacyDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "pharmacyEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("pharmacyDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.pharmacy.mediconnect.enitity")
                .persistenceUnit("db1")
                .build();
    }

    @Primary
    @Bean(name = "pharmacyTransactionManager")
    public PlatformTransactionManager pharmacyTransactionManager(
            @Qualifier("pharmacyEntityManagerFactory") EntityManagerFactory
                    pharmacyEntityManagerFactory
    ) {
        return new JpaTransactionManager(pharmacyEntityManagerFactory);
    }
}
