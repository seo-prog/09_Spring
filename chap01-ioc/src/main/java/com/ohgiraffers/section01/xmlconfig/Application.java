package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        // GenericApplicationContext 얘는 context 에 있는 bean 불러오는 애
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        // 1.Bean 의 이름으로 꺼내오는 방법
        //  MemberDTO member = (MemberDTO) context.getBean("member");

        // 2.Bean 의 타입으로 꺼내오는 방법
        // MemberDTO 의 형식인 애를 꺼내온다는 의미
        // MemberDTO member = context.getBean(MemberDTO.class);

        // 3.Bean 의 이름과 타입을 전달하여 꺼내오는 방법
        // 첫 번째 인자로 이름, 두 번째 인자로 타입을 넘기는 가장 안전한 방법.
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println("member = " + member);

        /*
        *   이렇게 생성된 객체 (빈) 은 생명주기를 개발자가 신경 쓸 필요 없이 의존성과 생명 주기가 스프링 컨텍스트에 의해 관리된다..
        *   xml 에 등록된 객체는 스프링 컨테이너에 저장되고, 어플리케이션이 실행되는 동안 MemberDTO 객체가 필요하면
        *   스프링 컨테이너에서 관리되는 빈을 주입받아 사용할 수 있다..
        *   스프링 컴테이너의 빈을 기본적으로 싱글톤으로 관리하기 떄문에, 어플리케이션 전반에 동일한 인스턴스를 공유할 수 있다..
        * */

        /*
        * Inversion of Control (IOC 제어의 역전)
        * Spring 컨테이너는 제어의 역전을 기반으로 한 객체 관리 시스템
        * 객체의 생성 및 의존성 관리를 개발자가 직접 하지 않고, 컨테이너가 대신 수행하도록 하는 개념이다..
        * 이에 관리되는 객체를 Spring Bean 이라고 부른다..
        *
        * 1. 객체 관리
        * - Spring 컨테이너는 어플리케이션에서 필요한 객체를 생성하고 관리한다..
        * 이로 인해 객체의 생명주기를 spring 에서 관리하게 되어, 개발자는 객체의 생명과 소멸에 대해 신경 쓸 필요가 없어진다..
        *
        * 2. 의존성 주입
        * Bean 등록을 통해 서로 다른 클래스 간의 의존성을 쉽게 주입할 수 있다..
        * ( A 객체가 B 객체를 사용해야 하는 상황 - 의존성)
        *  일반적으로 개발자가 직접 전달해주어야 하지만, 컨테이너가 이 의존성을 자동으로 주입해준다..
        *
        * */

    }
}
