package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;


    @Autowired  //외부에서 데이터를 넣어주는것 << DI
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}//end of class
