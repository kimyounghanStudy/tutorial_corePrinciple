package com.example.kimyoungstudy.repository;

import com.example.kimyoungstudy.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);

    //JPQL select m from Member m where m.name = ?

}
