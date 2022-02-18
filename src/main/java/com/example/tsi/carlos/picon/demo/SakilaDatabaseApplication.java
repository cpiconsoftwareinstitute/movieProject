package com.example.tsi.carlos.picon.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import software.amazon.awssdk.regions.Region;



import java.util.Base64;


import java.util.Optional;
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
	//@Autowired
	//private ReviewRepository reviewRepository;

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
	@PostMapping("/AddActors")
	public @ResponseBody
	String addActor(@RequestParam String first_name, String last_name){
		Actor addActor = new Actor(first_name, last_name);
		actorRepository.save(addActor);
		return save;
	}
	@GetMapping("/OneActor/{actor_id}")
	public @ResponseBody
	Optional<Actor> getActorByID(@PathVariable int actor_id){

		return actorRepository.findById(actor_id);
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

	@GetMapping("/OneFilm/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmByID(@PathVariable int film_id){

		return filmRepository.findById(film_id);
	}
	@PostMapping ("/AddFilms")
	public @ResponseBody String addFilm(@RequestParam String title, String description, int release_year, int rental_duration,
										double rental_rate, int length, double replacement_cost, String rating,
										String special_features){
		Film addFilm = new Film(title, description, release_year, rental_duration,
				rental_rate,length,replacement_cost, rating,
				special_features);
		filmRepository.save(addFilm);
		return save;
	}
	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms(){

		return filmRepository.findAll();
	}
	@GetMapping("/OneLanguage/{language_id}")
	public @ResponseBody
	Optional<Language> getLanguageByID(@PathVariable int language_id){

		return languageRepository.findById(language_id);
	}
	/*@PutMapping("/UpdateLanguages/{language_id}")
	public @ResponseBody
	String updateLanguage(@PathVariable int language_id, @RequestParam String name) {
		Optional<Language> updateLanguage= languageRepository.findById(language_id);
		updateLanguage.setName(name);
		return "Language updated";

	}*/

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
	@DeleteMapping("/DeleteLanguages/{language_id}")
	public @ResponseBody
	String removeLanguage(@PathVariable int language_id){
		languageRepository.deleteById(language_id);
		return "The language was removed";
	}
	/*@PostMapping("/AddReviews")
	public @ResponseBody
	String addReview(@RequestParam String reviewcol, int film_film_id){
		Review addReview = new Review(reviewcol, film_film_id);
		reviewRepository.save(addReview);
		return save;
	}
	@GetMapping("/AllReviews")
	public @ResponseBody
	Iterable<Review> getAllReview(){

		return reviewRepository.findAll();
	}*/


	}
