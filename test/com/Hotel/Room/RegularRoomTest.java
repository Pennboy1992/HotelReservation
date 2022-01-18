package com.Hotel.Room;



import org.junit.jupiter.api.Test;

class RegularRoomTest {
    private RegularRoom regularGuy = new RegularRoom("Roman",3,6,"2022-01-09");

    @Test
    void getRoomNumber() {
        System.out.println(regularGuy.getRoomNumber());
    }

    @Test
    void calculateCost() {
        System.out.println(regularGuy.calculateCost());
    }

}