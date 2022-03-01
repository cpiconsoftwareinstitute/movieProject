package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.*;

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
    private Set<Film> film = new HashSet<>();
    @Test
    public void test_GetFilm(){
        Language language = new Language("Urdu");
        film.add(new Film("Vanilla Sky", "The Best Movie Ever", 1992, 1,
                7, 13,  "G"));
        language.setFilm(film);
        assertEquals(film,language.getFilm(),"Get/Set film method is not working");
    }

}
