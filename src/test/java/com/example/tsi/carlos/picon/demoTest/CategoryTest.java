package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.Category;

import com.example.tsi.carlos.picon.demo.Film;
import com.example.tsi.carlos.picon.demo.Language;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {

    private Category category = new Category("Drama");

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

    private Set<Film> film = new HashSet<>();
    @Test
    public void test_GetFilm(){
        Category category = new Category("Urdu");
        film.add(new Film("Vanilla Sky", "The Best Movie Ever", 1992, 1,
                7, 13,  "G", 1));
        category.setFilm(film);
        assertEquals(film,category.getFilm(),"Get/Set film method is not working");
    }
}