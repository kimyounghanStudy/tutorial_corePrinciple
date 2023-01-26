package com.example.springcoreprinciple.member;


/**
 * 이거는 멤버 레파지토리
 * 잘 만들어주세요
 */
public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
