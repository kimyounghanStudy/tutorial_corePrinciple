package com.example.springcoreprinciple.order;

import com.example.springcoreprinciple.AppConfig;
import com.example.springcoreprinciple.member.Grade;
import com.example.springcoreprinciple.member.Member;
import com.example.springcoreprinciple.member.MemberServiceImple;
import com.example.springcoreprinciple.member.Memberservice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    Memberservice memberservice ;
    OrderService orderService ;
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberservice = appConfig.memberservice();
        orderService = appConfig.orderService();
    }

    @Test     //기븐 덴 왠 기억하자 ..!!!
    void creatOrder(){
        Long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberservice.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
                ///
    }

}
