package com.mycompany.doordashPlus;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration       // @Bean需要在有这个@Configuration底下才可以
@EnableWebMvc
public class ApplicationConfig {

    @Bean(name = "sessionFactory")          // external class用@Bean
    public LocalSessionFactoryBean sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.mycompany.doordashPlus.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() throws IOException {

        Properties prop = new Properties();
        String propFileName = "config.properties";

        //        read config file by using input stream
        InputStream inputStream = ApplicationConfig.class.getClassLoader().getResourceAsStream(propFileName);
        prop.load(inputStream);
        String url = prop.getProperty("sql_url");
        String username = prop.getProperty("sql_username");
        String password = prop.getProperty("sql_password");

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }


    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        return hibernateProperties;
    }

}
