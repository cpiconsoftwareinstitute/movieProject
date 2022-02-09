package com.example.tsi.carlos.picon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/Homepage")
public class SakilaDatabaseApplication {

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private LanguageRepository languageRepository;

	private String save ="save";

	public SakilaDatabaseApplication(AddressRepository addressRepository,
									 ActorRepository  actorRepository,
									 CategoryRepository categoryRepository,
									 CityRepository cityRepository,
									 CountryRepository countryRepository,
									 FilmRepository filmRepository,
									 LanguageRepository languageRepository){


		this.addressRepository = addressRepository;
		this.actorRepository = actorRepository;
		this.categoryRepository = categoryRepository;
		this.countryRepository = countryRepository;
		this.cityRepository = cityRepository;
		this.filmRepository = filmRepository;
		this.languageRepository = languageRepository;

	}

	public static void main(String[] args) {


		SpringApplication.run(SakilaDatabaseApplication.class, args);
	}
	@GetMapping("/AllAddresses")
	public @ResponseBody
	Iterable<Address> getAllAddresses(){

		return addressRepository.findAll();
	}
	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){

		return actorRepository.findAll();
	}
	@PostMapping("/AddCategories")
	public @ResponseBody
	String addCategory(@RequestParam String name){
		Category addCategory = new Category(name);
		categoryRepository.save(addCategory);
		return save;
	}
	@GetMapping("/AllCategories")
	public @ResponseBody
	Iterable<Category> getAllCategories(){

		return categoryRepository.findAll();
	}

	@GetMapping("/AllCities")
	public @ResponseBody
	Iterable<City> getAllCities(){

		return cityRepository.findAll();
	}
	@GetMapping("/AllCountries")
	public @ResponseBody
	Iterable<Country> getAllCountries(){

		return countryRepository.findAll();
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms(){

		return filmRepository.findAll();
	}
	@PostMapping("/AddLanguages")
	public @ResponseBody
	String addLanguage(@RequestParam String name){
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable<Language> getAllLanguages(){

        return languageRepository.findAll();
	}

	}
