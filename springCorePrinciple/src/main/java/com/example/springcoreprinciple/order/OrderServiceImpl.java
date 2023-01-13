package com.example.springcoreprinciple.order;

import com.example.springcoreprinciple.discount.DiscountPolicy;
import com.example.springcoreprinciple.discount.FixDiscountPolicy;
import com.example.springcoreprinciple.member.Member;
import com.example.springcoreprinciple.member.MemberRepository;
import com.example.springcoreprinciple.member.MemoryMemberRepository;



public class OrderServiceImpl implements  OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //단일 책임 원칙이 잘 지켜짐 .. 왜 ? 일을 시키니까 일 을 시키는것이 중요 하다 !!!!!!!!!
        return  new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
