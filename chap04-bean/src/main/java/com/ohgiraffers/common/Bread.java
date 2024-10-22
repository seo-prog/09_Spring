package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product{

    private Date bakedDate;

    public Bread() {
        super();
        // 원래 기본생성자에 super 자동으로 붙지만 헷갈릴까봐 써둠
    }


    public Bread(String name, int price, Date bakedDate) {
        super(name, price);
        this.bakedDate = bakedDate;
    }

    public Date getBakedDate() {
        return bakedDate;
    }

    public void setBakedDate(Date bakedDate) {
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.bakedDate;
    }
}
