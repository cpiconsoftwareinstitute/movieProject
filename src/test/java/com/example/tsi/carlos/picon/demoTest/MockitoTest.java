package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)//Inehereting characteristic needed to use mockito
public class MockitoTest {
    private SakilaDatabaseApplicationTests sakilaDatabaseApplicationTests;
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
    private LanguageRepository languageRepository; //Creating a fake version of

    @BeforeEach//creating an instance of our DB with no data
    void Setup(){
        sakilaDatabaseApplicationTests = new SakilaDatabaseApplicationTests(addressRepository,
                actorRepository,categoryRepository,
                cityRepository, countryRepository, filmRepository, languageRepository);
    }

    @Test
    public void testAddLanguage(){
        Language saveLanguage = new Language("Test Language");//Post request for Mock DB
        String expected = "save";//response
        String actual = sakilaDatabaseApplicationTests.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        //Verifying that repo has saved instance
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data d=hasnt been added to mock");
    }
}
