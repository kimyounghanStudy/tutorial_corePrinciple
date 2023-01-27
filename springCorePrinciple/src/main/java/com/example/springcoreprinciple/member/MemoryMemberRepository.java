package com.example.springcoreprinciple.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/** 아직 저장소가 선정되지 않았기 때문에 가장 기본이 되는 메모리에다 저장해버린다 */
@Component
public class MemoryMemberRepository implements MemberRepository {

    /**ConcurrentHashMap 을 사용하는게 좋다 동시성 이슈를 처리 할려면 ..?!*/
    private static Map<Long , Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
