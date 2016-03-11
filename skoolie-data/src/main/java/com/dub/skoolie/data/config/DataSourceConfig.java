
package com.dub.skoolie.data.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Kevin W.
 */
@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class DataSourceConfig {
    
    @Value("${database.driver}")
    private String driver;
    
    @Value("${database.url}")
    private String url;
    
    @Value("${database.user}")
    private String user;
    
    @Value("${database.password}")
    private String passwd;
    
    @Value("${database.coredb}")
    private String coredb;
    
    private static final String AUTO_CONNECT = "?autoReconnect=true";    
    private static final Integer INIT_SIZE = 4;
    private static final Integer MIN_EVICT = 600000;
    private static final Integer TIME_BETWEEN_EVICTIONS = 300000;
    
    
    @Bean
    public DataSource schooliecoreDataSource() {
        BasicDataSource src = new BasicDataSource();
        StringBuilder str = new StringBuilder();
        str.append(url).append(coredb).append(AUTO_CONNECT);
        src.setDriverClassName(driver);
        src.setUrl(str.toString());
        src.setUsername(user);
        src.setPassword(passwd);
        src.setInitialSize(INIT_SIZE);
        src.setMinEvictableIdleTimeMillis(MIN_EVICT);
        src.setTimeBetweenEvictionRunsMillis(TIME_BETWEEN_EVICTIONS);
        return src;
    }

}
