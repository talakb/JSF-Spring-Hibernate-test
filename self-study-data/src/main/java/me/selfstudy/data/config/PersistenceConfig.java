package me.selfstudy.data.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("me.selfstudy.data")
@PropertySource({ "classpath:persistence-mysql.properties" })  
public class PersistenceConfig {

	@Autowired
	private Environment env;


	@Bean(name="dataSource")
	public DataSource mysqlDataSource(){
		MysqlDataSource mySqlDataSource = new MysqlDataSource();
		mySqlDataSource.setUrl(env.getProperty("jdbc.url")); 
		mySqlDataSource.setUser(env.getProperty("jdbc.url"));
		mySqlDataSource.setPassword(env.getProperty("jdbc.pass"));
		mySqlDataSource.setDatabaseName(env.getProperty("jdbc.dbName"));
		return mySqlDataSource;

	}

	@Bean  
	public LocalSessionFactoryBean sessionFactory() {  
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();  
		sessionFactory.setDataSource(mysqlDataSource());  
		sessionFactory.setPackagesToScan(new String[] { "me.selfstudy.data" });  
		sessionFactory.setHibernateProperties(hibernateProperties());  

		return sessionFactory;  
	} 


	@Bean  
	@Autowired  
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {  
		HibernateTransactionManager txManager = new HibernateTransactionManager();  
		txManager.setSessionFactory(sessionFactory);  

		return txManager;  
	}  

	@Bean  
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {  
		return new PersistenceExceptionTranslationPostProcessor();  
	}  

	private  Properties hibernateProperties() {  
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));  
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));  
		hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", env.getProperty("hibernate.globally_quoted_identifiers"));

		return hibernateProperties;
	}  

}
