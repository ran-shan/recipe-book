
package com.recipebook.api.flyway;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * Since all database migrations (e.g. Flyway) are executed before JPA/Hibernate
 * is initialized this class (in combination with "spring.flyway.enabled=false"
 * in "application.propreties") ensures that preloading of data is executed
 * after JPA/Hibernate creates database schema. Because of that migration
 * scripts must start from "V2" ("V1" is used as baseline and those files are
 * ignored).
 */
@Configuration
class FlywayConfiguration {

    @Autowired
    public FlywayConfiguration(DataSource dataSource) {
        Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
    }
}
