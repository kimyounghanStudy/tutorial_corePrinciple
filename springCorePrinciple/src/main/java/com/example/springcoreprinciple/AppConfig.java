package com.example.springcoreprinciple;

import com.example.springcoreprinciple.discount.FixDiscountPolicy;
import com.example.springcoreprinciple.member.MemberServiceImple;
import com.example.springcoreprinciple.member.Memberservice;
import com.example.springcoreprinciple.member.MemoryMemberRepository;
import com.example.springcoreprinciple.order.OrderService;
import com.example.springcoreprinciple.order.OrderServiceImpl;

public class AppConfig {

    public Memberservice memberservice() {
        return new MemberServiceImple(new MemoryMemberRepository());  //여기서 구현체가 주입됨..!
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository() , new FixDiscountPolicy());
    }
}
