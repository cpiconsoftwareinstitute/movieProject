package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
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

    @BeforeEach
//creating an instance of our DB with no data
    void Setup() {
        sakilaDatabaseApplication = new SakilaDatabaseApplication(addressRepository,
                actorRepository, categoryRepository,
                cityRepository, countryRepository, filmRepository, languageRepository
//                ,reviewRepository
        );
    }

    /********************Actor*************************/
    @Test
    public void getGetActorMapping() {
        Actor Actor_A1 = new Actor("Michael", "J. Fox");
        Actor Actor_A2 = new Actor("Samuel", "L. Jackson");
        List<Actor> actorList = new ArrayList<>();
        actorList.add(Actor_A1);
        actorList.add(Actor_A2);
        when(sakilaDatabaseApplication.getAllActors()).thenReturn(actorList);
        Assertions.assertEquals(actorList, sakilaDatabaseApplication.getAllActors(),

                "The Expected list and the introduced data is not the same");
    }

    @Test
    public void testAddActor() {
        Actor saveActor = new Actor("Al", "Pacino");//Post request for Mock DB
        String expected = "save";//response
        String actual = sakilaDatabaseApplication.addActor(saveActor.getFirst_name(),
                saveActor.getLast_name());
        ArgumentCaptor<Actor> ActorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        //Verifying that repo has saved instance
        verify(actorRepository).save(ActorArgumentCaptor.capture());
        ActorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data d=hasnt been added to mock");
    }

    @Test
    public void testGetActorById() {
        Actor actorTest = new Actor("Robert", "De Niro");
        when(sakilaDatabaseApplication.getActorByID(1)).thenReturn(Optional.of(actorTest));
        Assertions.assertEquals(Optional.of(actorTest),
                sakilaDatabaseApplication.getActorByID(1),
                "This Language Id getting test has failed");
    }
    @Test
    public void deleteActor() {
        // given
        Actor deleteActor = new Actor("Mel", "Gibson");
        String actual = sakilaDatabaseApplication.removeActor(deleteActor.getActor_id());
        Assertions.assertEquals(actual,
                sakilaDatabaseApplication.removeActor(1),
                "This delete by Language Id  has failed");
    }
    /********************Address**********************/
    @Test
    public void getGetAddressMapping() {
        Address Address_A1 = new Address("270 Stepleton Road", "BS5 0NW");
        Address Address_A2 = new Address("221B Baker Street,", "NW1 6XE");
        List<Address> addressList = new ArrayList<>();
        addressList.add(Address_A1);
        addressList.add(Address_A2);
        when(sakilaDatabaseApplication.getAllAddresses()).thenReturn(addressList);
        Assertions.assertEquals(addressList, sakilaDatabaseApplication.getAllAddresses(),

                "The Expected list and the introduced data is not the same");
    }

    /********************Categories**********************/
    @Test
    public void getGetCategoriesMapping() {
        Category Category_A1 = new Category("Drama");
        Category Category_A2 = new Category("Science Fiction");
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(Category_A1);
        categoryList.add(Category_A2);
        when(sakilaDatabaseApplication.getAllCategories()).thenReturn(categoryList);
        Assertions.assertEquals(categoryList, sakilaDatabaseApplication.getAllCategories(),

                "The Expected list and the introduced data is not the same");
    }

    @Test
    public void testAddCategory() {
        Category saveCategory = new Category("Test Category");//Post request for Mock DB
        String expected = "save";//response
        String actual = sakilaDatabaseApplication.addCategory(saveCategory.getName());
        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        //Verifying that repo has saved instance
        verify(categoryRepository).save(categoryArgumentCaptor.capture());
        categoryArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data d=hasnt been added to mock");
    }
    @Test
    public void deleteCategory() {
        // given
        Category deleteCategory = new Category("Musical");
        String actual = sakilaDatabaseApplication.removeLanguage(deleteCategory.getCategory_id());
        Assertions.assertEquals(actual,
                sakilaDatabaseApplication.removeCategory(1),
                "This delete by Language Id  has failed");
    }
    /********************Cities************************/
    @Test
    public void getGetMappingCitiesTest() {
        City testCity1 = new City("Bogotá");
        City testCity2 = new City("Cali");
        List<City> cityList = new ArrayList<>();
        cityList.add(testCity1);
        cityList.add(testCity2);
        when(sakilaDatabaseApplication.getAllCities()).thenReturn(cityList);
        Assertions.assertEquals(cityList, sakilaDatabaseApplication.getAllCities(),

                "The Expected list and the introduced data is not the same");
    }

    /********************Countries************************/
    @Test
    public void getGetMappingCountriesTest() {
        Country testCountry1 = new Country("Colombia", "Updated, 20/02/2022");
        Country testCountry2 = new Country("Mexico, ", "Updated, 20/02/2022");
        List<Country> countryList = new ArrayList<>();
        countryList.add(testCountry1);
        countryList.add(testCountry2);
        when(sakilaDatabaseApplication.getAllCountries()).thenReturn(countryList);
        Assertions.assertEquals(countryList, sakilaDatabaseApplication.getAllCountries(),

                "The Expected list and the introduced data is not the same");
    }

    /********************Films***************************/
    @Test
    public void testAddFilms() {
        Film saveFilm = new Film("Interstellar",
                "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, " +
                        "Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, " +
                        "to find a new planet for humans",
                2014, 1, 7, 13,
                "G", 1);//Post request for Mock DB
        String expected = "save";//response
        String actual = sakilaDatabaseApplication.addFilm(saveFilm.getTitle(), saveFilm.getDescription(),
                saveFilm.getRelease_year(), saveFilm.getLanguage_id(), saveFilm.getRental_duration(),
                saveFilm.getLength(), saveFilm.getRating(), saveFilm.getCategory_id());
        ArgumentCaptor<Film> filmArgumentCaptor = ArgumentCaptor.forClass(Film.class);
        //Verifying that repo has saved instance
        verify(filmRepository).save(filmArgumentCaptor.capture());
        filmArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data d=hasnt been added to mock");
    }
    @Test
    public void deleteFilms() {
        // given
        Film deleteFilm = new Film("Interstellar",
                "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, " +
                        "Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, " +
                        "to find a new planet for humans",
                2014, 1, 7, 13,
                "G", 1);
        String actual = sakilaDatabaseApplication.removeFilm(deleteFilm.getFilm_id());
        Assertions.assertEquals(actual,
                sakilaDatabaseApplication.removeFilm(1),
                "This delete by Language Id  has failed");}
    @Test
    public void testGetFilmsById() {
        Film filmTest = new Film("Un long dimanche de fiançailles",
                "En 1919, Mathilde a 19 ans. Deux ans plus tôt, son fiancé Manech est parti" +
                        " sur le front de la Somme. De faux espoirs en certitudes, elle va démêler peu" +
                        " à peu la vérité sur le sort de Manech et de ses quatre camarades",
                2004, 1, 7, 13, "G", 1);
        when(sakilaDatabaseApplication.getFilmByID(1)).thenReturn(Optional.of(filmTest));
        Assertions.assertEquals(Optional.of(filmTest),
                sakilaDatabaseApplication.getFilmByID(1),
                "This film Id getting test has failed");
    }

    @Test
    public void getGetFilmsMapping() {
        Film Film_A1 = new Film("Vanilla Sky", "The Best Movie Ever", 1992, 1,
                7, 13, "G", 1);
        Film Film_A2 = new Film("The Godfather", "The Great Movie Ever", 1972, 1,
                12, 12, "SG", 1);
        List<Film> filmList = new ArrayList<>();
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
    public void testGetLanguageById() {
        Language languageTest = new Language("English");
        when(sakilaDatabaseApplication.getLanguageByID(1)).thenReturn(Optional.of(languageTest));
        Assertions.assertEquals(Optional.of(languageTest),
                sakilaDatabaseApplication.getLanguageByID(1),
                "This Language Id getting test has failed");
    }

    /*@Test
    public void testUpdateLanguage() {
        Language updateLanguage = new Language("Test Language");//Post request for Mock DB
        String expected = "save";//response
        String actual = sakilaDatabaseApplication.updateLanguage(saveLanguage.getName());
        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        //Verifying that repo has saved instance
        verify(languageRepository).save(languageArgumentCaptor.capture());
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data d=hasnt been added to mock");
    }*/

    @Test
    public void deleteLanguage() {
        // given
        Language deleteLanguage = new Language("Urdu");
        String actual = sakilaDatabaseApplication.removeLanguage(deleteLanguage.getLanguage_id());
        Assertions.assertEquals(actual,
                sakilaDatabaseApplication.removeLanguage(1),
                "This delete by Language Id  has failed");
    }
    /*

    @Test
    public void updateLanguage() {
        // given
        Language updateLingua = new Language("Urdu");
        when(sakilaDatabaseApplication.updateLanguage(updateLingua.getLanguage_id(), updateLingua.getName())).thenReturn(updateLingua.getName());
        String actual = sakilaDatabaseApplication.updateLanguage(1,"urdu");
        Assertions.assertEquals(actual,
                updateLingua.getName(),
                "This update by Language Id  has failed");
    }
    @Test
    public void updateLanguage(){
        Language Lingua = new Language("Urdu");
        // given - precondition or setup
        given(languageRepository.save(Lingua)).willReturn(Lingua);
        Lingua.setLanguage_id(1);
        Lingua.setName("Spanish");
        // when -  action or the behaviour that we are going test
        String updatedLingua = sakilaDatabaseApplication.updateLanguage(1, "Spanish");

        // then - verify the output
        assertThat(updatedFilm.getL()).isEqualTo(1);
        assertThat(updatedFilm.getTitle()).isEqualTo("SuperBad");
    }

    /*
        @Test
        public void testDeleteLanguageById(){
            Language languageTest = new Language("English");
            when(sakilaDatabaseApplication.removeLanguage(1)).thenReturn(null);
            Assertions.assertEquals(Optional.of(languageTest),
                    sakilaDatabaseApplication.getLanguageByID(1),
                    "This Language Id getting test has failed");
        }
    */
    @Test
    public void getGetMappingLanguageTest() {
        Language testName1 = new Language("Spanish");
        Language testName2 = new Language("Polish");
        List<Language> languageList = new ArrayList<>();
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

