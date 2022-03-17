package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HelloController {


    @GetMapping("hello")
    public String hello(Model model){
        //웹페이지에서의 데이터 변수:data, 값:hello
      model.addAttribute("data", "hello!!!!!");

        // return 에서는 resources/templates/hello.html을 템플릿엔진이 찾는다.
        //찾으면 viewResolver가 화면처리를 해준다.
        return "hello";
    }
}
