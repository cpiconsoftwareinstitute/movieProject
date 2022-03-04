/*package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
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

public class menuCucumberStepDef {

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
    @BeforeEach
//creating an instance of our DB with no data
    void Setup() {
        sakilaDatabaseApplication = new SakilaDatabaseApplication(addressRepository,
                actorRepository, categoryRepository,
                cityRepository, countryRepository, filmRepository, languageRepository
//                ,reviewRepository
        );
    }


    Language newLanguage;
    @Given("I want to add a new language")
    public void i_want_to_add_a_new_language() {
        Setup();
        // Write code here that turns the phrase above into concrete actions
        newLanguage = new Language("Urdu");//Post req for mock db
    }

    String actual;
    @When("A new language was added")
    public void a_new_language_was_added() {
        // Write code here that turns the phrase above into concrete actions
        actual = sakilaDatabaseApplication.addLanguage(newLanguage.getName());

    }
    @Then("the language should turn out in the language list and return save")
    public void the_language_should_turn_out_in_the_language_list_and_return_save() {
        // Write code here that turns the phrase above into concrete actions
        String expected = "save";//response

        ArgumentCaptor<Language>languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());// throws exception if data not stored in mock db
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected,actual,"Data hasn't been added to mock DB");

    }

}
*/
package com.example.tsi.carlos.picon.demoTest;

import com.example.tsi.carlos.picon.demo.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class menuCucumberStepDef {
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

    @BeforeEach
        // creating an instance of our db with no data
    void Setup() {

        languageRepository = mock(LanguageRepository.class);
        actorRepository = mock(ActorRepository.class);
        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        languageRepository = mock(LanguageRepository.class);
        actorRepository = mock(ActorRepository.class);
        filmRepository = mock(FilmRepository.class);
        categoryRepository = mock(CategoryRepository.class);

        sakilaDatabaseApplication = new SakilaDatabaseApplication(addressRepository,
                actorRepository, categoryRepository,
                cityRepository, countryRepository, filmRepository, languageRepository
//                ,reviewRepository
        );
    }

    /*****************************Adding************************************/
    Language newLanguage;

    @Given("I want to add a new language")
    public void i_want_to_add_a_new_language() {
        Setup();
        // Write code here that turns the phrase above into concrete actions
        newLanguage = new Language("Test Language");//Post req for mock db
    }

    String actual;

    @When("A new language was added")
    public void a_new_language_is_added() {
        // Write code here that turns the phrase above into concrete actions
        actual = sakilaDatabaseApplication.addLanguage(newLanguage.getName());

    }


    @Then("The language should turn out in the language list and return save")
    public void added_language_is_now_ib_the_language_list_and_() {
        // Write code here that turns the phrase above into concrete actions
        String expected = "save";//response

        ArgumentCaptor<Language> languageArgumentCaptor = ArgumentCaptor.forClass(Language.class);
        verify(languageRepository).save(languageArgumentCaptor.capture());// throws exception if data not stored in mock db
        languageArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual, "Data hasn't been added to mock DB");

    }

    Actor newActor;

    @Given("I want to add a new Actor")
    public void add_a_new_Actor() {
        Setup();
        // Write code here that turns the phrase above into concrete actions
        newActor = new Actor("Scarlett", "Johansson");//Post req for mock db
    }

    String actual_actor;

    @When("A new Actor is now in the List")
    public void a_new_actor_was_added() {
        // Write code here that turns the phrase above into concrete actions
        actual_actor = sakilaDatabaseApplication.addActor(newActor.getFirst_name(),
                newActor.getLast_name());

    }

    @Then("The Actor should turn out in the Actor list and return save")
    public void the_actor_should_be_now_in_the_language_list_and_saved() {
        // Write code here that turns the phrase above into concrete actions
        String expected = "save";//response

        ArgumentCaptor<Actor> ActorArgumentCaptor = ArgumentCaptor.forClass(Actor.class);
        //Verifying that repo has saved instance
        verify(actorRepository).save(ActorArgumentCaptor.capture());
        ActorArgumentCaptor.getValue();
        Assertions.assertEquals(expected, actual_actor, "Data d=hasnt been added to mock");

    }

    /*****************************Getting************************************/
    Language testName1;
    Language testName2;
    List<Language> languageList;
    @Given("I want to display all the languages")
    public void getting_languages() {
        Setup();
        testName1 = new Language("Spanish");
        testName2 = new Language("Polish");
        languageList = new ArrayList<>();

    }
    @When("I call all the data to be displayed")
    public void all_the_data_called() {
        languageList = new ArrayList<>();
        languageList.add(testName1);
        languageList.add(testName2);


    }

    @Then("The data is displayed")
    public void data_displayed() {
        when(sakilaDatabaseApplication.getAllLanguages()).thenReturn(languageList);
        Assertions.assertEquals(languageList, sakilaDatabaseApplication.getAllLanguages(),

                "The Expected list and the introduced data is not the same");

    }

    /*****************************Getting************************************/
    Language deleteLanguage;
    String actual2;
    @Given("I want to delete a language")
    public void deleting_languages() {
        Setup();
        deleteLanguage = new Language("Urdu");

    }
    @When("I introduce an id and I press the delete button")
    public void press_the_button() {
        actual2 = sakilaDatabaseApplication.removeLanguage(deleteLanguage.getLanguage_id());


    }

    @Then("The data is not in the data base anymore")
    public void data_disappeared() {
        Assertions.assertEquals(actual2,
                sakilaDatabaseApplication.removeLanguage(1),
                "This delete by Language Id  has failed");
    }
}