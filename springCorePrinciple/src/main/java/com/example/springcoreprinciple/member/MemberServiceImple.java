package com.example.springcoreprinciple.member;

public class MemberServiceImple implements Memberservice{

    /**자장할 구현체를 선택 역할과 구현 ..! 그니까  구현체가 메모리 멤버레포지토리로 선정 추가로 컨트롤 쉬프트 엔터 애용해주자*/
    private  final MemberRepository memberRepository = new MemoryMemberRepository();

    /**다형성에 의해 멤버레포지토리에 있는 세이브가 아닌 메모리멤버레포지토리에서 오버라이드한 세이브가 호출됨*/
    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
