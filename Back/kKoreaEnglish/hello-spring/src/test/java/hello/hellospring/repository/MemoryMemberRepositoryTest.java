package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {
//    MemberRepository repository = new MemoryMemberRepository();
    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @AfterEach
    public void AfterEach(){
        //테스트 메소드가 끝나면 항상 실행되는 영역. 메모리를 초기화 하기위해서 실행되는 영역
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring2");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertEquals(result, member);
        System.out.println("aaaa");
        assertThat(member).isEqualTo(result);
        System.out.println("bbbb");
//        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        System.out.println("b");
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

    //save의 경우 제일 마지막에 실행될 경우에 오류가 날 수 있다.
    // 테스트의 경우는 순서에 의존된 테스트를 구성하면 안된다.
    //테스트가 끝나면 데이터를 지워주는 코드를 추가해줘야한다.



}
