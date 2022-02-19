package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.Country;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryTest {

    @Test
    void setCountryTest(){
        Country testCountry = new Country();
        testCountry.setCountry("Colombia", "");
        assertEquals("Colombia", testCountry.getCountry(),
                "The Expected result and the introduced data is not the same");
    }
    @Test
    void setLast_UpdateTest(){
        Country testLast_Update = new Country();
        testLast_Update.setCountry("", "Everything is fine. 19/02/2022");
        assertEquals("Everything is fine. 19/02/2022", testLast_Update.getLast_update(),
                "The Expected result and the introduced data is not the same");
    }
    @Test
    void getIDTest(){
        Country testID = new Country();
        assertEquals(0, testID.getCountry_id(),
                "The Expected ID and the introduced data is not the same");
    }
}
