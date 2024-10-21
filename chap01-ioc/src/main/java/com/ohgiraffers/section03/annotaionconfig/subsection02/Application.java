package com.ohgiraffers.section03.annotaionconfig.subsection02;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext
                ("section03/annotationconfig/subsection02/xml/spring-context.xml");

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("beanName: " + beanName);

        }

        // MemberDAO bean 을 가지고 온다.
        MemberDAO memberDAO = context.getBean(MemberDAO.class);
        System.out.println(memberDAO.selectMember(1)); // 그 안의 값도 가져올 수 있다.
        System.out.println(memberDAO.insertMember(new MemberDTO(
                3, "user03", "pass03", "최서연"
        ))); // 추가
        System.out.println(memberDAO.selectMember(3));



    }
}
