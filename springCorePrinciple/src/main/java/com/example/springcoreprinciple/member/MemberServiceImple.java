package com.example.springcoreprinciple.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImple implements MemberService{

    /**자장할 구현체를 선택 역할과 구현 ..! 그니까  구현체가 메모리 멤버레포지토리로 선정 추가로 컨트롤 쉬프트 엔터 애용해주자*/
    private  final MemberRepository memberRepository ;    ///



    @Autowired // ac.getBean(MemberRepository.class)
    public MemberServiceImple(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;   //외부
    }

    /**다형성에 의해 멤버레포지토리에 있는 세이브가 아닌 메모리멤버레포지토리에서 오버라이드한 세이브가 호출됨*/
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
