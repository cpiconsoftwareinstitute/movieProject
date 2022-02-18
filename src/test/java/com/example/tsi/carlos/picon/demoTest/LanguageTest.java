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
    private SakilaDatabaseApplication sakilaDatabaseApplication;
    private Language lingua = new Language();
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private ActorRepository actorRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CityRepository cityRepository;
    @Mock
    private CountryRepository countryRepository;
    @Mock
    private FilmRepository filmRepository;
    @Mock
    private LanguageRepository languageRepository;
    //@Mock
    //private ReviewRepository reviewRepository; //Creating a fake version of

    @BeforeEach
////creating an instance of our DB with no data
    void Setup(){
        sakilaDatabaseApplication = new SakilaDatabaseApplication(addressRepository,
                actorRepository,categoryRepository,
                cityRepository, countryRepository, filmRepository, languageRepository);
    }
    private Language language= new Language("Drama");
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


 /*@Test
   public void getGetMappingTest(){
       Language testName1 = new Language("Spanish");
       Language testName2 = new Language("Polish");
       List<Language> languageList= new ArrayList<>();
       languageList.add(testName1);
      languageList.add(testName2);
      when(sakilaDatabaseApplication.getAllLanguages()).thenReturn(languageList);
        Assertions.assertEquals(languageList, sakilaDatabaseApplication.getAllLanguages(),

              "The Expected list and the introduced data is not the same");
   }*/
}
