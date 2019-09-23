package fr.projet.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@PropertySource("classpath:application.properties")
public class JpaConfiguration {

	@Autowired
	private Environment env;

	@Bean(name = "jpaDataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty("jpa.driver"));
		dataSource.setUrl(env.getRequiredProperty("jpa.url"));
		dataSource.setUsername(env.getRequiredProperty("jpa.user"));
		dataSource.setPassword(env.getRequiredProperty("jpa.password"));

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] { "fr.projet" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(additionalProperties());

		return emf;
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		properties.setProperty("hibernate.use_second_level_cache", env.getRequiredProperty("hibernate.use_second_level_cache"));
		return properties;
	}
	
	@Bean
	public PlatformTransactionManager txManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
	   return new PersistenceExceptionTranslationPostProcessor();
	}
}
