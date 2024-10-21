package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // 이 클래스의 bean 들을 가져다 쓸 수 있다.

        MemberDTO member = context.getBean(MemberDTO.class);
        // MemberDTO 자료형인 bean 을 가지고 온다.
        System.out.println(member);

        // 입금
        System.out.println(member.getPersonalAccount().deposit(10000));
        // 잔액 출력
        System.out.println(member.getPersonalAccount().getBalance());
        // 출금
        System.out.println(member.getPersonalAccount().withdraw(5000));
        // 잔액 출력
        System.out.println(member.getPersonalAccount().getBalance());
        // 출금
        System.out.println(member.getPersonalAccount().withdraw(10000));



    }
}
