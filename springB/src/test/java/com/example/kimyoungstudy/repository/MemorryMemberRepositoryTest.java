package com.example.kimyoungstudy.repository;

import com.example.kimyoungstudy.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemorryMemberRepositoryTest {


    MemorryMemberRepository repository = new MemorryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public  void save(){
        Member member = new Member();
        member.setName("String");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

       /* Assertions.assertEquals(member,result);*/

        assertThat(member).isEqualTo(result);


    }

    @Test
    public void findbyName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();  //아 이름을 찾아오는게 아닌 그 이름의 멤버 객체를 찾아오는것!

        assertThat(member1).isEqualTo(result); //아 이름을 찾아오는게 아닌 그 이름의 멤버 객체를 찾아오는것!
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
