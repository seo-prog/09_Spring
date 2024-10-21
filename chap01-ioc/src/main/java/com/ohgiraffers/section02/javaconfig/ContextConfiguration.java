package com.ohgiraffers.section02.javaconfig;


import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Member;

@Configuration("configurationSection02") // xml 파일을 대신한다고 생각해라
public class ContextConfiguration {

    // name 생략 가능 그냥 문자열만 등록도 가능.  이름을 따로 지정하지 않으면 메소드 이름을 빈의 이름으로 갖는다.
    @Bean(name = "member") // 메소드에 bean 을 붙이면 이 메소드의 반환값을 bean 으로 등록하겠다는 뜻.
    public MemberDTO getMember(){
        return new MemberDTO
                (1,"user02","pass","홍길동");
    }


}
