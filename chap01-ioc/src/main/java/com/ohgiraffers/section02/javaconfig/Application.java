package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // 이 ㅣ클래스의 bean 들을 불러와 사용할 수 있다는 의미이다..
        // 자바 내에서 bean 을 만들어서 부르는 방식.

        MemberDTO member = (MemberDTO) context.getBean("member");
        System.out.println("member = " + member);
    }
}
