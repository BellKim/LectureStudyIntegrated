package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {

        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

        //  member.getname 이 넘어온 name 과 같은지 필터링한다. 찾으면 반환을 한다.

    }

    @Override
    public List<Member> findAll() {
        // 리스트 전체를 반환한다.
        return new ArrayList<>(store.values());
    }

    public void clearStore() {

        store.clear();
    }

}