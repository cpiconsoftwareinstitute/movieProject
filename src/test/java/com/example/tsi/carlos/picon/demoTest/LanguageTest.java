package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class LanguageTest {


    @Test
    void setNameTest(){
        Language testName = new Language();
        testName.setName("Spanish");
        assertEquals("Spanish", testName.getName(),
                "The Expected result and the introduced data is not the same");
    }
    @Test
    void getIDTest(){
       Language testID = new Language();
        assertEquals(0, testID.getLanguage_id(),
               "The Expected ID and the introduced data is not the same");
  }

}
