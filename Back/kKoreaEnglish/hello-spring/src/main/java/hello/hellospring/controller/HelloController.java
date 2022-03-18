package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    //http://localhost:8089/hello-mvc
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){

        System.out.println("naem print = " + name);

        model.addAttribute("name", name);

        return "hello-template";
    }


}
