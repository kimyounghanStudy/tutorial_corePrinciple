package com.example.springcoreprinciple.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SinglettonTest {


    @Test
    void singtonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SinglettonBean.class);

        SinglettonBean bean1 = ac.getBean(SinglettonBean.class);
        SinglettonBean bean2 = ac.getBean(SinglettonBean.class);

        assertThat(bean1).isSameAs(bean2);

        ac.close(); // close 호출됨 .!
    }

    @Scope("singleton")
    static class SinglettonBean{

        @PostConstruct
        public void init() {
            System.out.println("SinglettonBean.init");
        }
        @PreDestroy
        public void close() {
            System.out.println("SinglettonBean.close");

        }
    }
}
