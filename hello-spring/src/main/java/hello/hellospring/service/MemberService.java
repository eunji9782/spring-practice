package hello.hellospring.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	//회원가입
	public Long join(Member member) {
		//중복회원 안됨
		validateDup(member);
		
		memberRepository.save(member);
		return member.getId();
	}
	
	private void validateDup(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m -> {
				throw new IllegalStateException("이미 존재하는 회원입니다");
			});
	}
	
	//전체 회원 조회
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	//아이디 조회
	public Optional<Member> findOne(Long memberId){
		return memberRepository.findById(memberId);
	}
}
