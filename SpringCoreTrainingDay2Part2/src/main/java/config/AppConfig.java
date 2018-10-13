package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan({"repositories","services"})
@EnableTransactionManagement
public class AppConfig {
    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/gradsday2");
        dataSource.setUsername("root");
        dataSource.setPassword("root1234");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
    @Bean
    public PlatformTransactionManager transactionManager()
    {
        DataSourceTransactionManager transactionManager= new DataSourceTransactionManager(dataSource());

        return transactionManager;
    }
    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        return new JdbcTemplate(dataSource());
    }
}
