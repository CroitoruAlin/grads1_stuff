package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan({"repositories","services"})
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public LocalEntityManagerFactoryBean emf()
    {
        LocalEntityManagerFactoryBean emf=new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("java4c6e1");
        return emf;
    }


    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
    {
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager; //manageriaza tranzactiile
    }
}
