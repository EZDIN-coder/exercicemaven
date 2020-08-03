package fr.exercices.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.afpa.exercices.bdd.mysql.MySQLAccess;



/**
 * @author bilonjea
 *
 */
@Configuration
@ComponentScan({"com.test.freme.spring"})
public class AppConfiguration {
	
	
    
	
	@Bean(name="mysql")
	public MySQLAccess getMySQLAccess() {
		
		return new MySQLAccess();
		
	}
	

}
