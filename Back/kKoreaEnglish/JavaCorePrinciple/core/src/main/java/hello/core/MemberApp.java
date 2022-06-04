package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberservice = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);  //cmd+opt+v

        memberservice.join(member);

        Member findMembbber = memberservice.findMember(1L);

        System.out.println("findmember = " + member);
        System.out.println("find member = "  + findMembbber);

        System.out.println("findmember = " + member.getName());
        System.out.println("find member = "  + findMembbber.getName());






    }

}
