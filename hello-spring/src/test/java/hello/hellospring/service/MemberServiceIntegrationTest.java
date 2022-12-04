package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void join() {
		Member member = new Member();
		member.setName("spring");
		Long result = memberService.join(member);
		
		Member findMember = memberService.findOne(result).get();
		assertThat(member.getName()).isEqualTo(findMember.getName()); 
	}
	
	//중복 시 예외를 던지는지 테스트
	@Test
	public void joinDup() {
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
	
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
	
	}
	
	@Test
	public void findMembers(){
		Member member = new Member();
		member.setName("spring");
		memberService.join(member);
		
		Member member2 = new Member();
		member2.setName("spring2");
		memberService.join(member2);
		
		List<Member> result = memberService.findMembers();
		assertThat(result.size()).isEqualTo(2);
	}
	
	@Test
	public void findOne() {
		Member member = new Member();
		member.setName("spring");
		Long memberId = memberService.join(member);
		
		Member member2 = new Member();
		member2.setName("spring2");
		memberService.join(member2);
		
		Member findMember = memberService.findOne(memberId).get();
		assertThat(member).isEqualTo(findMember);	
	}

}
