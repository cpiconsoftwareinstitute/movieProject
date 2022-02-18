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

    @Test
    void setRental_duration(){

        Film testRental_duration = new Film();
        testRental_duration.setRental_duration(7);
        assertEquals(7, testRental_duration.getRental_duration(),
                "The Expected result and the introduced data is not the same");
    }

    @Test
        void setRental_rate(){

        Film testRental_rate = new Film();
        testRental_rate.setRental_rate(15.20);
        assertEquals(15.20, testRental_rate.getRental_rate(),
                "The Expected result and the introduced data is not the same");
    }

    @Test
    void setLength(){

        Film testLength = new Film();
            testLength.setLength(13);
        assertEquals(13, testLength.getLength(),
                "The Expected result and the introduced data is not the same");
    }
    @Test
    void setReplacement_cost(){

        Film testReplacement_cost = new Film();
        testReplacement_cost.setReplacement_cost(13.5);
        assertEquals(13.5, testReplacement_cost.getReplacement_cost(),
                "The Expected result and the introduced data is not the same");
    }

    @Test
    void setRating(){

        Film testRating = new Film();
        testRating.setRating("G");
        assertEquals("G", testRating.getRating(),
                "The Expected result and the introduced data is not the same");
    }

    @Test
    void setSpecial_features(){

        Film testSpecial_features = new Film();
        testSpecial_features.setSpecial_features("Special scenes");
        assertEquals("Special scenes", testSpecial_features.getSpecial_features(),
                "The Expected result and the introduced data is not the same");
    }
}
