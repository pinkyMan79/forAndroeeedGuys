package org.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.example.config.additions.DataBasePropertySource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = "org.example.repository")
public class DataBaseConfig {

    private final DataBasePropertySource propertySource;

    @Bean
    public DataSource dataSource(){
        return new HikariDataSource();
    }

    @Bean
    public HikariConfig hikariConfig(){
        HikariConfig config = new HikariConfig();
        config.setDataSource(dataSource());
        config.setJdbcUrl(propertySource.getUrl());
        config.setUsername(propertySource.getUsername());
        config.setPassword(propertySource.getPassword());
        config.setDriverClassName(propertySource.getDriver());
        config.setMaximumPoolSize(propertySource.getMaxPoolSize());
        return config;
    }

    /*@Bean         Deprecated for a moment
    SpringLiquibase liquibase(){
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }*/

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.ddl.auto", "create");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();
        containerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        containerEntityManagerFactoryBean.setPackagesToScan("org.example.models");
        containerEntityManagerFactoryBean.setJpaProperties(hibernateProperties());
        containerEntityManagerFactoryBean.setDataSource(dataSource());
        return containerEntityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory manager){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(manager);
        return transactionManager;
    }
}
