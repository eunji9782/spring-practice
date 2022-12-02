package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberServiceTest {
	
	MemberService memberService = new MemberService();
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach
	public void clear() {
		repository.clearStore();
	}
	
	@Test
	public void join() {
		Member member = new Member();
		member.setName("spring");
		Long result = memberService.join(member);
		assertThat(result).isEqualTo(1); 
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
		memberService.join(member);
		
		Member member2 = new Member();
		member2.setName("spring2");
		memberService.join(member2);
		
		Optional<Member> result = memberService.findOne(1L);
		assertThat(member).isEqualTo(result);	
	}

}
