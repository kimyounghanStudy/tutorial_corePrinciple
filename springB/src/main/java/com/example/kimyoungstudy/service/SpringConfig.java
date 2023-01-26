package com.example.kimyoungstudy.service;

import com.example.kimyoungstudy.aop.TimeTraceAop;
import com.example.kimyoungstudy.repository.MemberRepository;
import com.example.kimyoungstudy.repository.MemorryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //수동빈등록
public class  SpringConfig {

    private final MemberRepository memberRepository;


    @Autowired  //생성자가 하나일 경우에는 생략가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);  //왜 안되는거지 ..? 이건 ..다시 한번 봐야겠다 중간에 안따라하니까 꼬인듯.. 아... 메소드가아닌 .. 의존관계 세팅..
        // 아... 난 역시 아직 잘 모르는구나 ... 주의 하자 ..
        //
    }

 /*   @Bean
    public MemberRepository memberRepository() {
        return new MemorryMemberRepository();
    }*/

   /* @Bean
    public TimeTraceAop timeTraceAop() {
        return timeTraceAop();
    }*/
}
