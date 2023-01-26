package com.example.springcoreprinciple;

import com.example.springcoreprinciple.member.Grade;
import com.example.springcoreprinciple.member.Member;
import com.example.springcoreprinciple.member.MemberService;
import com.example.springcoreprinciple.member.MemberServiceImple;

import com.example.springcoreprinciple.order.Order;
import com.example.springcoreprinciple.order.OrderService;
import com.example.springcoreprinciple.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
/*
        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberservice = appConfig.memberService();*/


        ApplicationContext aC = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = aC.getBean("memberService", MemberService.class);
        OrderService orderService = aC.getBean("orderService", OrderService.class);


/*
        Memberservice memberservice = new MemberServiceImple();
        OrderService orderService = new OrderServiceImpl();*/

        Long memberId= 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
