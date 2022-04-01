package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
//auto create test class -> cmd + shift + T => check bottom list.
    MemberService memberService = new MemberService();

    //회원가입.
    @Test
    void join() {
        //테스트코드의 기본순서패턴
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();

        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}