package com.example.kimyoungstudy.repository;

import com.example.kimyoungstudy.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemorryMemberRepository implements MemberRepository {

    private  static Map<Long,Member> store = new HashMap<>(); //실무에서는 동시성 때문에 다른 map자료형을 쓴다는데?
    private  static long sequence = 0L; //이것도 동시성고려해서 다른거 쓴다는데 ? 동시성 자주나온다 ..!
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member ->member.getName().equals(name)).findAny();
        //이렇게 하는 이유는 Map 으로 저장했는데 name값은 value 라서 ?
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore() {
        store.clear();
    }
}
