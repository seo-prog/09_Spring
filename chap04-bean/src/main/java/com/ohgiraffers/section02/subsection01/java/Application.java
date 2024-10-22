package com.ohgiraffers.section02.subsection01.java;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // 빈이 바로 동작하여 가게 문 열었다는 메세지 출력

        Product cartBread = context.getBean("cartBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        // 첫 번째 손님이 쇼핑 카트를 꺼낸다
        ShoppingCart cart = context.getBean("cart", ShoppingCart.class);
        cart.addItem(cartBread);
        cart.addItem(milk);
        System.out.println("cart 에 담긴 물품 : " + cart.getItems());

        // 두 번째 손님이 카트를 꺼낸다
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(water);
        System.out.println("cart 에 담긴 물품" + cart2.getItems());

        ((AnnotationConfigApplicationContext)context).close();
        // 가비지 컬렉터가 데이터를 수거해갈때 종료할텐데 우리가 실행 종료 이후에 가비지 컬렉터가 수거를 해간다.
        // 즉, 우리가 강제로 해주지 않으면 종료를 볼 수 없음.
        // 다시 형변환을 시켜줘야 close 를 할 수 있다.

    }
}
