package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LanguageTest {

    private Language lingua = new Language();

    @Test
    void setNameTest(){
        Language testName = new Language();
        testName.setName("Spanish");
        assertEquals("Spanish", testName.getName(),
                "The Expected result and the introduced data is not the same");

    }

}
