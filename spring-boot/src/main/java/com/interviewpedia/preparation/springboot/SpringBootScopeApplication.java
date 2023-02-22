package com.interviewpedia.preparation.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <p><b>Bean Scope:</b></p>
 *
 * <p><b>1. Singleton: </b> one instance per Spring context</p>
 * <p><b>2. Prototype: </b> new bean whenever requested</p>
 * <p><b>3. Request: </b> one bean per HTTP request</p>
 * <p><b>4. Session: </b> one bean per HTTP session</p>
 */
@SpringBootApplication
public class SpringBootScopeApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBootScopeApplication.class);
        Business1 business1 = applicationContext.getBean(Business1.class);
        System.out.println(business1);
        System.out.println(business1.getDao());

        Business1 business2 = applicationContext.getBean(Business1.class);
        System.out.println(business2);
        System.out.println(business2.getDao());
    }

    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    private static class Business1 {
        @Autowired
        private Dao1 dao;

        public Dao1 getDao() {
            return dao;
        }
    }

    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    private static class Business2 {
        @Autowired
        private Dao2 dao;

        public Dao2 getDao() {
            return dao;
        }
    }

    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    private static class Dao1 {

    }

    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    private static class Dao2 {

    }
}
