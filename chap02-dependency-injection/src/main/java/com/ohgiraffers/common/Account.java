package com.ohgiraffers.common;

public interface Account {
    // 구현 책임을 의무화
    // 우리 클래스에는 이 세개의 메소드를 반드시 가지고 있어야 한다.

    String getBalance(); // 잔액

    String deposit(int money); // 입금

    String withdraw(int money); // 출금


}
