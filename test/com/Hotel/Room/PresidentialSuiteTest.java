package com.Hotel.Room;



import org.junit.Test;



class PresidentialSuiteTest {
    private PresidentialSuite room = new PresidentialSuite("Roman",4,6,"2022-01-09");

    @Test
    void getRoomNumber() {
        System.out.println(room.getRoomNumber());
    }

    @Test
    void calculateCost() {
    }
}