package com.example.springcoreprinciple.beanfind;

import com.example.springcoreprinciple.AppConfig;
import com.example.springcoreprinciple.member.MemberService;
import com.example.springcoreprinciple.member.MemberServiceImple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

   @Test
   @DisplayName("빈이름으로 조회")
    void findBeanByName(){

       MemberService memberService = ac.getBean("memberService", MemberService.class);
       System.out.println("memberService = " + memberService);
       System.out.println("memberService.getClass() = " + memberService.getClass());

       assertThat(memberService).isInstanceOf(MemberServiceImple.class);

   }
 @Test
   @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType(){

       MemberService memberService = ac.getBean(MemberService.class);
       System.out.println("memberService = " + memberService);
       System.out.println("memberService.getClass() = " + memberService.getClass());

       assertThat(memberService).isInstanceOf(MemberServiceImple.class);

   }

   @Test
   @DisplayName("구체 타입으로만 조회")
    void findBeanByType2(){

       MemberService memberService = ac.getBean("memberService",MemberServiceImple.class);
       System.out.println("memberService = " + memberService);
       System.out.println("memberService.getClass() = " + memberService.getClass());

       assertThat(memberService).isInstanceOf(MemberServiceImple.class);

   }

   @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX(){
       // ac.getBean("xxxx", MemberService.class);

     /*  MemberService xxxx = ac.getBean("xxxxx", MemberService.class);*/

       //예외 터지는거 검증..하자!
                            // 오른쪽이 실행되면 왼쪽의 예외가 터져야 한다는말
       assertThrows(NoSuchBeanDefinitionException.class,()->ac.getBean("xxxx", MemberService.class));

   }
}


