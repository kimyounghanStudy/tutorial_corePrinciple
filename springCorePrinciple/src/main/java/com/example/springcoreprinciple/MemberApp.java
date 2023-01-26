package com.example.springcoreprinciple;

import com.example.springcoreprinciple.member.Grade;
import com.example.springcoreprinciple.member.Member;
import com.example.springcoreprinciple.member.MemberService;
import com.example.springcoreprinciple.member.MemberServiceImple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
/*
        AppConfig appConfig = new AppConfig();

        Memberservice memberservice = appConfig.memberservice();*/

        /*Memberservice memberservice = new MemberServiceImple();*/


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//"메소드이름" ,클래스이름.class 꺼내쓸때


        /**컨트롤 알트 v 해주면  new 객체 에서 자동으로 앞에 쓸말 생성해줌 .!*/
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());   //꿀팁이다 soutv 하면 위에꺼에서 비슷한 양식에 변수 선택해서 바꿔줌 !



    }
}
