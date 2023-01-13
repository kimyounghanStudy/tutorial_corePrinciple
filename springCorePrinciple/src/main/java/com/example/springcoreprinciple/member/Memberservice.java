package com.example.springcoreprinciple.member;

/** 생각해라 ... 이건 역할을 만드는거야 .. ! 멤버 서비스는 저장과..조회 기능이있다*/
public interface Memberservice {
    /**그래서 저장기능 */
    void join(Member member);

    /**멤버아이디를 가지고 조회*/
    Member findMember(Long memberId);
}
