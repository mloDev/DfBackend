package de.mlo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication(exclude = SessionAutoConfiguration.class)
@EnableJpaRepositories(basePackages = "de.mlo.Repository")
@EntityScan(basePackages = "de.mlo.model")
public class BootReactApplication {
	
	/** The init. */
	@Value("${init.json}")
	private String init;

	public static void main(String[] args) {
	  SpringApplication.run(BootReactApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
	  
  	/**
	 * Repository populator.
	 *
	 * @return the jackson2 repository populator factory bean
	 */
	@Bean
	public Jackson2RepositoryPopulatorFactoryBean repositoryPopulator() {
		Resource sourceData;
		Jackson2RepositoryPopulatorFactoryBean factory;
			try {
				sourceData = new PathResource(init);
				if(!sourceData.exists())
					sourceData = new ClassPathResource(init);
				factory = new Jackson2RepositoryPopulatorFactoryBean();
				factory.setResources(new Resource[] { sourceData });
			} catch (Exception e) {
				return null;
			}
	
			return factory;
	  }
}
