package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.Address;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    private Address address= new Address("270A Stepleton Road, Brsitol", "BS5 0NW");

    @Test
    void setAddressTest(){
        Address testAddress = new Address();
        testAddress.setAddress("270A Stepleton Road, Brsitol","BS5 0NW" );
        assertEquals("270A Stepleton Road, Brsitol", testAddress.getAddress(),
                "The Expected result and the introduced data is not the same");
    }
    @Test
    void setDistrictTest(){
        Address testDistrict = new Address();
        testDistrict.setAddress("270A Stepleton Road, Brsitol", "BS5 0NW");
        assertEquals("BS5 0NW", testDistrict.getDistrict(),
                "The Expected result and the introduced data is not the same");
    }
    @Test
    void getIDTest(){
        Address testID = new Address();
        assertEquals(0, testID.getAddress_id_id(),
                "The Expected ID and the introduced data is not the same");
    }
}
