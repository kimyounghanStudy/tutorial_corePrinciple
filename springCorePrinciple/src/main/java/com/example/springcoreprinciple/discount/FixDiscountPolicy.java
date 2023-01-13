package com.example.springcoreprinciple.discount;

import com.example.springcoreprinciple.member.Grade;
import com.example.springcoreprinciple.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {   // enum 클래스는 == 비교해야함 ..!
            return  discountFixAmount;
        }
        return 0;
    }
}
