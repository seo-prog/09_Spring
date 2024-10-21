package com.ohgiraffers.section03.annotaionconfig.subsection01;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        /*
        * ComponentScan
        * base Packages 로 설정 된 하위 경로에 특정 어노테이션을 가지고 있는 클래스를 bean 으로 등록하는 기능이다..
        * @Component 어노테이션이 작성된 클래스를 인식하여 bean 으로 등록한다..
        * 특수 목적에 따라 @Controller, @Service 등을 사용한다..
        * */

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // memberDAO 는 그냥 클래스 자체가 빈이 된것이고
        // ContextConfiguration 클래스의 이름인 configurationSection03 은 memberDAO 빈을 부르는 빈이다.


        String[] beanNames = context.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            System.out.println("bean : " + beanName);
        }

        // 따로 new 로 생성해주지 않아도 memberDAO 를 주입받을 수 있다.
        MemberDAO memberDAO = context.getBean(MemberDAO.class);
        System.out.println(memberDAO.selectMember(1)); // 그 안의 값도 가져올 수 있다.
        System.out.println(memberDAO.insertMember(new MemberDTO(
                3, "user03", "pass03", "최서연"
        ))); // 추가
        System.out.println(memberDAO.selectMember(3));


    }
}
