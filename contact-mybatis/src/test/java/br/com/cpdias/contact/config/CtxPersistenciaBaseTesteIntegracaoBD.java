package br.com.cpdias.contact.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ContextConfiguration
@ComponentScan(basePackages = { "br.com.cpdias.contact" })
@EnableTransactionManagement
@PropertySource("classpath:jdbc-connection-test-integration.properties")
public class CtxPersistenciaBaseTesteIntegracaoBD {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment.getProperty("datasource.driver-class-name"));
		dataSource.setUrl(environment.getProperty("datasource.url"));
		dataSource.setUsername(environment.getProperty("datasource.username"));
		dataSource.setPassword(environment.getProperty("datasource.password"));
		
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	/*
	@Bean
  	public JtaTransactionManager transactionManager() {
       return new JtaTransactionManagerFactoryBean().getObject();
    }
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception {

		final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(ds);
		//sqlSessionFactory.setTransactionFactory(new ManagedTransactionFactory());
		sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		
		sqlSessionFactory.setFailFast(true);

		return sqlSessionFactory.getObject();
	}

	@Bean
	public SqlSession sqlSession(SqlSessionFactory sqlfactory) {
		
		return new SqlSessionTemplate(sqlfactory);
	}

}
