package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.City;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityTest {

    private City city = new City("Cali");

    @Test
    void setCityTest(){
        City testCity = new City();
        testCity.setCity("Bogotá");
        assertEquals("Bogotá", testCity.getCity(),
                "The Expected result and the introduced data is not the same");
    }

    @Test
    void getIDTest(){
        City testID = new City();
        assertEquals(0, testID.getCity_id(),
                "The Expected ID and the introduced data is not the same");
    }
}
