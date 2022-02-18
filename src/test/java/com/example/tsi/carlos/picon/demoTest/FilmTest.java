package com.example.tsi.carlos.picon.demoTest;


import com.example.tsi.carlos.picon.demo.Film;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmTest {

    @Test
    void setTitleTest(){

        Film testTitle = new Film();
        testTitle.setTitle("Vanilla Sky");
        assertEquals("Vanilla Sky", testTitle.getTitle(),
                "The Expected result and the introduced data is not the same");
    }

    @Test
    void setDescriptionTest(){

        Film testDescription = new Film();
        testDescription.setDescription("The Best Movie Ever");
        assertEquals("The Best Movie Ever", testDescription.getDescription(),
                "The Expected result and the introduced data is not the same");
    }

    @Test
    void setRelease_yearTest(){

        Film testRelease_year = new Film();
        testRelease_year.setRelease_year(1992);
        assertEquals(1992, testRelease_year.getRelease_year(),
                "The Expected result and the introduced data is not the same");
    }
}
