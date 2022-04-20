package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class HelloController {


    @GetMapping("hello")
    public String hello(Model model) {
        //웹페이지에서의 데이터 변수:data, 값:hello
        model.addAttribute("data", "hello!!!!!");

        // return 에서는 resources/templates/hello.html을 템플릿엔진이 찾는다.
        //찾으면 viewResolver가 화면처리를 해준다.
        return "hello";
    }

    //http://localhost:8089/hello-mvc
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {

        System.out.println("naem print = " + name);

        model.addAttribute("name", name);

        return "hello-template";
    }

    /*
        포트로 요청  -> 내장톰캣서버 ->  스프링 컨테이너에서 mapping리스트 에서 해당 매핑값 조회
         ->  viewResolver에서 templates 폴더의 html파일을 찾아서 타임리프 템플릿 엔진처리시작(웹페이지에서 표현될수있도록 html 형태로)
         웹브라우저에서 출력 
     */

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {

        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    /*
    Getter Setter 자동생성 : mac: cmd+n Win:ctrl+n 에서 getter, setter 클릭후 생성할 변수 선택후 ok
     */
    static class Hello {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
