
package com.dub.skoolie.data.config;

import com.googlecode.flyway.core.Flyway;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Kevin W.
 */
@Configuration
public class FlyWayConfig {
    
    private static final String SKOOLIE_MIGRATION_DIR = "classpath:db/migration/skoolie";
    
    @Autowired
    private DataSource skooliecoreDataSource;
    
    @Bean(initMethod = "migrate")
    public Flyway flywaySkoolie() {
        Flyway flwy = new Flyway();
        flwy.setDataSource(skooliecoreDataSource);
        flwy.setTable("skoolie_version");
        flwy.setLocations(SKOOLIE_MIGRATION_DIR);
        flwy.setInitOnMigrate(true);
        return flwy;
    }

}
