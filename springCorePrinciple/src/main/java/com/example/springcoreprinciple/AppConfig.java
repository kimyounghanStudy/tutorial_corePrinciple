package com.example.springcoreprinciple;

import com.example.springcoreprinciple.discount.DiscountPolicy;
import com.example.springcoreprinciple.discount.FixDiscountPolicy;
import com.example.springcoreprinciple.discount.RateDiscountPolicy;
import com.example.springcoreprinciple.member.MemberRepository;
import com.example.springcoreprinciple.member.MemberService;
import com.example.springcoreprinciple.member.MemberServiceImple;

import com.example.springcoreprinciple.member.MemoryMemberRepository;
import com.example.springcoreprinciple.order.OrderService;
import com.example.springcoreprinciple.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {     //@퀄리파이 !

    @Bean
    public MemberService memberService() {
        return new MemberServiceImple(memberRepository());  //여기서 구현체가 주입됨..!
    }          // 나는 멤버서비스야 .! 멤버서비스 임플을 반환할껀데 new 메모리레포지트리를 가지고 반환할꺼야

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), getDiscountPolicy());
    }

    @Bean
    public DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
