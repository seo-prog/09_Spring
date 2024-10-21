package com.ohgiraffers.section03.annotaionconfig.subsection01;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("configurationSection03") // 그냥 우리 구분할라고 걍 쓴거임. 별의미없음
@ComponentScan(basePackages = "com.ohgiraffers.common")
//ComponentScan 은 basePackages 의 ( 즉, "com.ohgiraffers.common") 하위 클래스중에 bean 이 있다면 모두 가지고 올 수 있다는 의미.
 public class ContextConfiguration {

}
