package com.ohgiraffers.section01.subsection01.scope;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        /*
        * bean scope 란?
        * 빈이 생성될 때 생성되는 인스턴스의 범위를 의미한다..
        * 스프링에서는 다양한 스코프를 제공한다.
        *
        * 1. singleton 하나의 인스턴스만 생성하고, 모든 빈이 해당 인스턴스를 공유한다..
        * 2. prototype 매번 새로운 인스턴스를 생성한다.,.
        * 3. request http 요청을 처리할 때 마다 새로운 인스턴스를 생성하고, 요청 처리가 끝나면
        *                   인스턴스를 폐기한다.
        * 4. session http 세션 당 하나의 인스턴스를 생성하고, 세션이 종료되면 인스턴스를 폐기한다.
        * */

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // 빈들을 만들어둔 클래스 이름을 적는것

        String[] beanNames = context.getBeanDefinitionNames(); // 빈의 이름들을 가지고온다.

        for(String bean:beanNames){
            System.out.println(bean);
        }
        // getbean() -> ApplicationContext 여기서 정의된 메서드로, 주어진 이름 또는 타입을 기반으로
        // 등록 된 빈 객체를 반환. 이 메서드를 사용하여 ApplicationContext 에서 관리되는 빈 객체를 검색하고 사용할 수 있다.

        // Product cartBread = context.getBean("내 빈 이름", 내 빈 클래스 );

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
        // cart 1 과 cart 2 에 담은 물품이 같은 곳에 담겨있다 !
        // ----> 이를 해결하기 위해 ! @scope 사용 !!!!!! ( 기본값이 sigleton annotaion 이다)
        // @Scope("prototype") 카트에 어노테이션으로 스코프를 적어주면 요청시마다 새로운 객체가 불러진다. 즉,
        // 다른 객체에 담긴다는 의미 !
        // 전체적으로 사용하는 객체는 싱글톤으로 관리하고 개인마다 ( 장바구니 같은건 ) 달라야 하는건 스코프로 관리한다 !

        System.out.println("cart = " + cart.hashCode());
        System.out.println("cart2 = " + cart2.hashCode());
        // 두개의 해쉬코드가 똑같다는건 동일 객체라는 의미 ! 즉, 싱글톤이므로 같은 객체인것이다.
    }
}
