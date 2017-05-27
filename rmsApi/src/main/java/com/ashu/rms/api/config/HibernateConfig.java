package com.ashu.rms.api.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class HibernateConfig {
	
	@Bean
    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
         HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
         factory.setEntityManagerFactory(emf);
         return factory;
    }
	

}
