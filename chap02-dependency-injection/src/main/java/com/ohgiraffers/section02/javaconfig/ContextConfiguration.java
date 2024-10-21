package com.ohgiraffers.section02.javaconfig;


import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20, "110-133-2222");
    }

    @Bean
    public MemberDTO memberGenerator(){
        MemberDTO memberDTO = new MemberDTO(30, "최서연", "010-3300-0000", "seo@gmail.com", accountGenerator());
        return memberDTO;
        // 위에 accountGenerator 가 빈이 아니라면 memberGenerator 를 부를때마다 계속 같은 객체가 생성이 될꺼임
        // 그러니까 빈으로 해주면 스프링이 알아서 생성후에 주입을 해준다는 것이다.
        // 싱글톤 - 똑같은 객체가 우리의 프로그램에 하나밖에 없다는 특성.
    }
}
