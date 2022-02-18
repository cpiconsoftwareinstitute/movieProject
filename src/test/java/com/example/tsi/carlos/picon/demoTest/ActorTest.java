package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.Actor;

import org.junit.jupiter.api.Test;

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
}
