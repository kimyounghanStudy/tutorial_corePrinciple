package com.example.springcoreprinciple.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifecycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfiig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();


    }

    @Configuration
    static class LifeCycleConfiig{

        @Bean(initMethod = "init")
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.seturl("http://hello-spring.dev");

            return networkClient;
        }
    }

}
