package com.ohgiraffers.section02.common;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // 파이리
@Primary // Pokemon 을 상속받는 동일한 타입의 클래스중에 우선적으로 연결하겠다는 의미.
public class Charmander implements Pokemon{

    @Override
    public void attack() {
        System.out.println(" 파이리 불꼬오오옷 ~!~!~!~!~!");
    }
}
