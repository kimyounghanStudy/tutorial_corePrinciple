package com.example.springcoreprinciple.singleton;

import com.example.springcoreprinciple.AppConfig;
import com.example.springcoreprinciple.member.MemberServiceImple;
import com.example.springcoreprinciple.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
      ApplicationContext ac =  new AnnotationConfigApplicationContext(AppConfig.class);


        MemberServiceImple memberService = ac.getBean("memberService", MemberServiceImple.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);

        assertThat(memberService.getMemberRepository()).isEqualTo(orderService.getMemberRepository());
        assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
    }

    @Test
    void    configurationDeep(){
        ApplicationContext ac =  new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
