package com.example.springcoreprinciple.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    Memberservice memberservice = new MemberServiceImple();
    @Test
    void join(){
        //given
        Member member = new Member( 1L,"memberA",Grade.VIP);

        //when
        memberservice.join(member);
        Member findMember = memberservice.findMember(1L);


        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
