package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)//Inehereting characteristic needed to use mockito
public class MockitoTest {
    private SakilaDatabaseApplication sakilaDatabaseApplication;
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
//    @Mock
//    private ReviewRepository reviewRepository; //Creating a fake version of

    @BeforeEach//creating an instance of our DB with no data
    void Setup(){
        sakilaDatabaseApplication = new SakilaDatabaseApplication(addressRepository,
                actorRepository,categoryRepository,
                cityRepository, countryRepository, filmRepository, languageRepository
//                ,reviewRepository
        );
    }
    /********************Address**********************/
    @Test
    public void getGetAddressMapping(){
        Address Address_A1 = new Address();
        Address Address_A2 = new Address();
        List<Address> addressList= new ArrayList<>();
        addressList.add(Address_A1);
        addressList.add(Address_A2);
        when(sakilaDatabaseApplication.getAllAddresses()).thenReturn(addressList);
        Assertions.assertEquals(addressList, sakilaDatabaseApplication.getAllAddresses(),

                "The Expected list and the introduced data is not the same");
    }
    /********************Categories**********************/
    @Test
    public void testAddCategory(){
        Category saveCategory = new Category("Test Category");//Post request for Mock DB
        String expected = "save";//response
        String actual = sakilaDatabaseApplication.addCategory(saveCategory.getName());
        ArgumentCaptor<Category>categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        //Verifying that repo has saved instance
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        categoryArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data d=hasnt been added to mock");
    }
    /********************Films***************************/
    @Test
    public void testGetFilmsById(){
        Film filmTest = new Film("Un long dimanche de fiançailles",
                "En 1919, Mathilde a 19 ans. Deux ans plus tôt, son fiancé Manech est parti" +
                        " sur le front de la Somme. De faux espoirs en certitudes, elle va démêler peu" +
                        " à peu la vérité sur le sort de Manech et de ses quatre camarades",
                2004, 7, 15.20, 13, 13.5,
                "G", "Interviews");
        when(sakilaDatabaseApplication.getFilmByID(1)).thenReturn(Optional.of(filmTest));
        Assertions.assertEquals(Optional.of(filmTest),
                sakilaDatabaseApplication.getFilmByID(1),
                "This film Id getting test has failed");
    }
    @Test
    public void getGetFilmsMapping(){
        Film Film_A1 = new Film("Vanilla Sky", "The Best Movie Ever", 1992,
                7, 15.20, 13, 13.5, "G",
                "Special scenes");
        Film Film_A2 = new Film("The Godfather", "The Great Movie Ever", 1972,
                12, 7.22, 12, 5, "SG",
                "Interview");
        List<Film> filmList= new ArrayList<>();
        filmList.add(Film_A1);
        filmList.add(Film_A2);
        when(sakilaDatabaseApplication.getAllFilms()).thenReturn(filmList);
        Assertions.assertEquals(filmList, sakilaDatabaseApplication.getAllFilms(),

                "The Expected list and the introduced data is not the same");
    }
    /********************Languages**********************/
    @Test
    public void testAddLanguage() {
        Language saveLanguage = new Language("Test Language");//Post request for Mock DB
        String expected = "save";//response
        String actual = sakilaDatabaseApplication.addLanguage(saveLanguage.getName());
        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        //Verifying that repo has saved instance
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data d=hasnt been added to mock");
    }
    @Test
    public void testGetLanguageById(){
        Language languageTest = new Language("English");
        when(sakilaDatabaseApplication.getLanguageByID(1)).thenReturn(Optional.of(languageTest));
        Assertions.assertEquals(Optional.of(languageTest),
                sakilaDatabaseApplication.getLanguageByID(1),
                "This Language Id getting test has failed");
    }

    @Test
    public void getGetMappingLanguageTest(){
        Language testName1 = new Language("Spanish");
        Language testName2 = new Language("Polish");
        List<Language> languageList= new ArrayList<>();
        languageList.add(testName1);
        languageList.add(testName2);
        when(sakilaDatabaseApplication.getAllLanguages()).thenReturn(languageList);
        Assertions.assertEquals(languageList, sakilaDatabaseApplication.getAllLanguages(),

                "The Expected list and the introduced data is not the same");
    }

    /*
    @Test
    public void testGetLanguage(){
        Language getLanguage = new Language("Test Language");//Post request for Mock DB
        Iterable<Language> testAllLanguages;
        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        //Verifying that repo has saved instance
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();

        Assertions.assertEquals(languageRepository.findAll(), sakilaDatabaseApplication.getAllLanguages()
                , "Data d=hasnt been added to mock");
    }
    */

//    /*
//    @Test
//    public void testOneLanguage(){
//        Language addoneLanguage = new Language("Test Language");//Post request for Mock DB
//        String expected = addoneLanguage.getName();//response
//        String actual = sakilaDatabaseApplication.oneLanguage(oneLanguage.getName());
//        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
//        //Verifying that repo has saved instance
//        verify(languageRepository).save(languageArgumentCaptor.capture());
//        languageArgumentCaptor.getValue();
//        Assertions.assertEquals(expected, actual, "Data d=hasnt been added to mock");
//    }*/



}
