package com.example.springcoreprinciple.order;

import com.example.springcoreprinciple.discount.DiscountPolicy;
import com.example.springcoreprinciple.discount.FixDiscountPolicy;
import com.example.springcoreprinciple.discount.RateDiscountPolicy;
import com.example.springcoreprinciple.member.Member;
import com.example.springcoreprinciple.member.MemberRepository;
import com.example.springcoreprinciple.member.MemoryMemberRepository;



public class OrderServiceImpl implements  OrderService{

    private final MemberRepository memberRepository;
    /*private final DiscountPolicy discountPolicy = new FixDiscountPolicy();*/
/*
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();*/  //변경시 DIP . OCP위반

    private  final DiscountPolicy discountPolicy ; //  처음수정에 ...final 뺀 이유는... final은 값을 할당해야하기 때문에

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //단일 책임 원칙이 잘 지켜짐 .. 왜 ? 일을 시키니까 일 을 시키는것이 중요 하다 !!!!!!!!!
        return  new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
