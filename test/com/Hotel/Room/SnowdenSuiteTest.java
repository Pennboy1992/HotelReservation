package com.Hotel.Room;


import org.junit.Test;

class SnowdenSuiteTest {
    private SnowdenSuite snowden = new SnowdenSuite("Roman",4,6,"2022-01-09");

    @Test
    void getRoomNumber() {
        System.out.println(snowden.getRoomNumber());
    }

}