package com.study.kotlinstudy.basic;

class Person {

    private String name;

    private String address;

    private String pNum;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return pNum;
    }

    public void setPhoneNum(String pNum) {
        this.pNum = pNum;
    }

}