package com.test.app01.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.test.app01.domain.Member;

@Repository
public class MemoryMemberRepository implements MemberRepository{

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence); //고유번호 증가시켜서 아이디에 셋팅
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		return Optional.ofNullable(store.get(id)); //store가 널일 수 있어서 optional로 감싼다
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream().filter(member -> member.getName().equals(name))
		.findAny();
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<Member>(store.values());
	}
	

}
