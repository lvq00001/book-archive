package com.lvq.bookArchive.config;

import javax.sql.DataSource;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.lvq.bookArchive")
public class RootApplicationContextConfig {

//	@Autowired
//	private Environment environment; 


//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
//		dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
//		dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
//		dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
//		return dataSource;
//	}
	
	
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/book_archive");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
	    return new JdbcTemplate(dataSource());
	}

	@Bean
	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource());
	}

}
