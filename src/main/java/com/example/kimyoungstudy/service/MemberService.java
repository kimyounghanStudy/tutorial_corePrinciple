package com.example.kimyoungstudy.service;

import com.example.kimyoungstudy.domain.Member;
import com.example.kimyoungstudy.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Long join(Member member){
        validateDuplicateMember(member); //같은값 걸러주는 메소드..만들자 .!

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m->{
           throw  new IllegalStateException("이미 존재하는 회원입니다.");
       });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findone(Long memberId){
        return memberRepository.findById(memberId);
    }
}
