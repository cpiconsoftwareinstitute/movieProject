package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.Category;
import com.example.tsi.carlos.picon.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {

    @Test
    void setNameTest() {
        Category testName = new Category();
        testName.setName("Drama");
        assertEquals("Drama", testName.getName(),
                "The Expected result and the introduced data is not the same");
    }

    @Test
    void getIDTest(){
        Category testName = new Category();
        assertEquals(0, testName.getCategory_id(),
                "The Expected ID and the introduced data is not the same");
    }

    
}