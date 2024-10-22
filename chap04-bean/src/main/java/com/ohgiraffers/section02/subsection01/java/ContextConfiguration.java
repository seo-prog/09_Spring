package com.ohgiraffers.section02.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
public class ContextConfiguration {

    @Bean
    public Product cartBread(){
        return new Bread("붕어빵", 1000, new Date());
    }

    @Bean
    public Product milk(){
        return new Beverage("딸기우유", 1500, 500);
    }

    @Bean
    public Product water(){
        return new Beverage("지리산암반수", 1000, 500);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }

    @Bean(initMethod = "openShop", destroyMethod = "closeShop")
    // 빈으로 등록될 때 가장 먼저 실행 될 메소드와 닫힐 때(context 가 종료될 때) 마지막으로 실행될 메소드 지정!
    public Owner owner(){
        return new Owner();
    }
}