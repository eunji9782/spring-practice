
package com.test.app01.repository;

import java.util.List;
import java.util.Optional;

import com.test.app01.domain.Member;

public interface MemberRepository {
	Member save(Member member); //멤버 저장
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll(); //모든 멤버 반환
}
