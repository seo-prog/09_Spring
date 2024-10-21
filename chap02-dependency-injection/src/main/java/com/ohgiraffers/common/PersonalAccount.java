package com.ohgiraffers.common;

public class PersonalAccount implements Account{
    // 구현 책임의 의무가 있으므로 3가지 메소드 오버라이드 할 의무.

    private final int bankCode; // 은행 코드

    private final String accNo; // 계좌번호
    // bankCode, accNo 를 final 로 한 이유는 우리 프로그램에선는 한번 지정 후 바뀌지 않을꺼기때문에.
    // final 이니까 세터도 생성 안됨.

    private int balance; // 잔액



    public PersonalAccount(int bankCode, String accNo) {
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    public int getBankCode() {
        return bankCode;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String getBalance() {
        return this.accNo + "계좌의 현재 잔액은" + this.balance + "원 입니다 !";
    }

    @Override
    public String deposit(int money) {
       String str = "";
       if(money > 0){
           this.balance += money;
           str = money + "원이 입금 되었습니다 !";
       }else{
           str = "금액이 잘못 입금 되었습니다 !";
       }
       return str;
    }

    @Override
    public String withdraw(int money) {
       String str = "";
       if(this.balance >= money){
           this.balance -= money;
           str = money + " 원이 출금 되었습니다 !";
       }else{
           str = "현재 잔액은 " + this.balance + " 원 입니다 ! " +
                   money + "원 보다 적습니다 !";
       }
       return str;
    }

    @Override
    public String toString() {
        return "PersonalAccount{" +
                "bankCode=" + bankCode +
                ", accNo='" + accNo + '\'' +
                ", balance=" + balance +
                '}';
    }
}
