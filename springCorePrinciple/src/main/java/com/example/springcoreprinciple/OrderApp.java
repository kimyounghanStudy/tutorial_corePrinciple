package com.example.springcoreprinciple;

import com.example.springcoreprinciple.member.Grade;
import com.example.springcoreprinciple.member.Member;
import com.example.springcoreprinciple.member.MemberServiceImple;
import com.example.springcoreprinciple.member.Memberservice;
import com.example.springcoreprinciple.order.Order;
import com.example.springcoreprinciple.order.OrderService;
import com.example.springcoreprinciple.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        Memberservice memberservice = new MemberServiceImple();
        OrderService orderService = new OrderServiceImpl();

        Long memberId= 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberservice.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }
}
