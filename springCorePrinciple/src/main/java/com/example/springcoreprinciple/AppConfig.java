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
    }          // 나는 멤버서비스야 .! 멤버서비스 임플을 반환할껀데 new 메모리레포지트리를 가지고 반환할꺼야

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository() , new FixDiscountPolicy());
    }
}
