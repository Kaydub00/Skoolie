
package com.dub.skoolie.data.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Kevin W.
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "skooliecoreEntityManagerFactory",
        transactionManagerRef = "skooliecoreTransactionManager",
        basePackages = {"com.dub.skoolie.data.dao"}
)
@EnableTransactionManagement
public class SkoolieJPAConfig {

    
    @Bean(name="skooliecoreEntityManagerFactory")
    @DependsOn("flywaySkoolie")
    public LocalContainerEntityManagerFactoryBean skooliecoreEntityManagerFactory(DataSource skooliecoreDataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(skooliecoreDataSource);
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPackagesToScan("com.dub.skoolie.data.entities");
        return factory;
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateVendorAdapter.setDatabase(Database.MYSQL);
        hibernateVendorAdapter.setShowSql(false);
        hibernateVendorAdapter.setGenerateDdl(true);
        hibernateVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
        return hibernateVendorAdapter;
    }
    
    
    @Bean 
    public JdbcTemplate jdbcTemplate(DataSource skooliecoreDataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(skooliecoreDataSource);
        return jdbcTemplate;
    }
}
