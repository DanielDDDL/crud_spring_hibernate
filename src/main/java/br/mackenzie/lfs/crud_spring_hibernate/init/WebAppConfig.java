/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.lfs.crud_spring_hibernate.init;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 *
 * @author Dias
 */
@Configuration
@ComponentScan({"br.mackenzie.lfs.crud_spring_hibernate"})
@EnableWebMvc
@EnableTransactionManagement
@PropertySources({
        @PropertySource("classpath:access.properties"),
        @PropertySource("classpath:database.properties")
})
public class WebAppConfig {
    
    //access and authentication properties
    private static final String PROPERTY_NAME_DATABASE_URL = "database.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "database.username";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "database.password";
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "database.driver";
    
    //hibernat config propeties
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

    private static final String PROPERTY_NAME_JNDI = "database.jndi";

    @Autowired
    private Environment env;
    
    private Properties hibernateProperties(){
        Properties properties = new Properties();
        properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        properties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
        properties.put(PROPERTY_NAME_HBM2DDL_AUTO,env.getRequiredProperty(PROPERTY_NAME_HBM2DDL_AUTO));
        return properties;  
    }
    
    @Bean
    public DataSource dataSource() {

        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource(env.getProperty(PROPERTY_NAME_JNDI));
        return dataSource;
    }
    
    @Bean
    public LocalSessionFactoryBean sessionFactory (){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(new String[] {"br.mackenzie.lfs.crud_spring_hibernate.model"} );
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        
        return sessionFactoryBean;
    }
    
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager (SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        
        return transactionManager;
    }
    
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
    
}
