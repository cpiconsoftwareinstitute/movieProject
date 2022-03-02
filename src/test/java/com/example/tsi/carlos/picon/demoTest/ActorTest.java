package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.Actor;

import com.example.tsi.carlos.picon.demo.Film;
import com.example.tsi.carlos.picon.demo.Language;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {

    private Actor actor = new Actor("James", "Caan");

    @Test
    void getIDTest() {
        Actor testID = new Actor();
        assertEquals(0, testID.getActor_id(),
                "The Expected ID and the introduced data is not the same");
    }

    @Test
    void setFirst_NameTest() {
        Actor testFName = new Actor();
        testFName.setFirst_name("James");
        assertEquals("James", testFName.getFirst_name(),
                "The Expected result and the introduced data is not the same");

    }

    @Test
    void setLast_NameTest() {
        Actor testLName = new Actor();
        testLName.setLast_name("Caan");
        assertEquals("Caan", testLName.getLast_name(),
                "The Expected result and the introduced data is not the same");

    }
    private Set<Film> film = new HashSet<>();
    @Test
    public void test_getActor(){
        film.add(new Film("Vanilla Sky", "The Best Movie Ever", 1992, 1,
                7, 13,  "G"));
        actor.setFilm(film);
        assertEquals(film,actor.getFilm(),"Get/Set Actor method is not working");

    }
}
