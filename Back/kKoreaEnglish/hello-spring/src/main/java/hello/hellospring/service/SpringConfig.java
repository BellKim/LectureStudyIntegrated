package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // memberservice 를 스프링 빈에 추가해준다.
    // memberRepository를 스프링 빈에 추가해준다.
    //이런 식으로 작성해주면 @autowired 를 해주지 않아도 된다.

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    //java코드로 스프링 빈을 등록하는 방법이다.
    /*
        왜 자바코드로 설정하지않고 이런식으로 설정하는가
        예전에는 xml으로 설정했기때문에 이러한 방법으로 매핑시키기도 했다.
        

     */

}// end of class
