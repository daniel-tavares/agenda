package br.com.agenda;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoFlyway {

	 @Autowired
	 private DataSource datasource;
	
	 
	 @Bean 
	 public Flyway flyway(){ 
		 return new Flyway(); 
     } 
	 
	 @Bean(initMethod = "migrate")
	 public Flyway flywayAgenda() {
		return getConfigFlyway("classpath:db/migration/h2-agenda", datasource); 
	 }
	 
	 @Bean(initMethod = "migrate")
	 public Flyway flywayOauth2() {
	    return getConfigFlyway("classpath:db/migration/h2-oauth2", datasource); 
	 }
	 
	 
	 public Flyway getConfigFlyway(String path, DataSource datasource) {
		 Flyway flyway = new Flyway();
		 flyway.setSqlMigrationPrefix("V");
		 flyway.setSqlMigrationSuffix(".sql");
		 flyway.setLocations(path);
		 flyway.setDataSource(datasource);
		return flyway;
	 }
	 
}
