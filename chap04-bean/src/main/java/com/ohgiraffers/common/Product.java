package com.ohgiraffers.common;

public abstract class Product {
    // abstract -> 추상 클래스/ 이거 자체로는 인스턴스를 못 만들고 공통 기능을 강제화하기 위해 사용!
    // 얘를 상속받으면 이 내용들을 다 사용할 수 있다. - 추상클래스의 장점 ! //

    private String name; // 상품명
    private int price; // 상품 가격

    public Product(){}

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " " + price;
    }
}



