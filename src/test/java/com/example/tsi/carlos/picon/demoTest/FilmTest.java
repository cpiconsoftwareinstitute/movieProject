package com.example.tsi.carlos.picon.demoTest;

import java.util.HashSet;
import java.util.Set;
import com.example.tsi.carlos.picon.demo.Actor;
import com.example.tsi.carlos.picon.demo.Film;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmTest {

    private Film film = new Film("Vanilla Sky", "The Best Movie Ever", 1992, 1,
            7, 13,  "G");


    private Set<Actor> actor = new HashSet<>();
    @Test
    void getIDTest() {
        Film testID = new Film();
        assertEquals(0, testID.getFilm_id(),
                "The Expected ID and the introduced data is not the same");
    }
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
    void setLanguage_idTest(){

        Film testLanguage_id = new Film();
        testLanguage_id.setLanguage_id(1);
        assertEquals(1, testLanguage_id.getLanguage_id(),
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
    void setRental_Duration(){

        Film testRental_duration = new Film();
        testRental_duration.setRental_duration(10);
        assertEquals(10, testRental_duration.getRental_duration(),
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
    public void test_getActor(){
        actor.add(new Actor("Al","Pacino"));
        film.setActor(actor);
        assertEquals(actor,film.getActor(),"Get/Set Actor method is not working");

    }

    /*@Test
    void setLanguage(){

        Film testLanguage = new Film();
        testLanguage.setLanguage("Urdu");
        assertEquals("Urdu", testLanguage.getLanguage(),
                "The Expected result and the introduced data is not the same");
    }*/

}
