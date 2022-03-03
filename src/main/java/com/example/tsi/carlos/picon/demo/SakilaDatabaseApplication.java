package com.example.tsi.carlos.picon.demo;

import com.amazonaws.services.secretsmanager.model.ResourceNotFoundException;
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
@CrossOrigin(origins = "http://localhost:3000")
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
	/********************Address**********************/
	@GetMapping("/AllAddresses")
	public @ResponseBody
	Iterable<Address> getAllAddresses(){

		return addressRepository.findAll();
	}
	/********************Actor*************************/

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
	@DeleteMapping("/DeleteActors/{actor_id}")
	public @ResponseBody
	String removeActor(@PathVariable int actor_id){
		actorRepository.deleteById(actor_id);
		return "The actor was removed";
	}
	@PutMapping("/updateActor/{actor_id}")
	public @ResponseBody
	String updateActor(@PathVariable int actor_id, @RequestParam String first_name, String last_name){
		Actor updateActor= actorRepository.findById(actor_id)
				.orElseThrow(() ->new ResourceNotFoundException("Actor ID not found"));
		updateActor.setFirst_name(first_name);
		updateActor.setLast_name(last_name);
		final Actor updatedActor = actorRepository.save(updateActor);
		return updatedActor.getFirst_name() + updatedActor.getLast_name();
	}
	/********************Categories**********************/
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/updateCategory/{category_id}")
	public @ResponseBody
	String updateCategory(@PathVariable int category_id, @RequestParam String name){
		Category updateCategory = categoryRepository.findById(category_id)
				.orElseThrow(() ->new ResourceNotFoundException("Category ID not found"));
		updateCategory.setName(name);
		final Category updatedCategory = categoryRepository.save(updateCategory);
		return updatedCategory.getName();
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
	@DeleteMapping("/DeleteCategories/{category_id}")
	public @ResponseBody
	String removeCategory(@PathVariable int category_id){
		categoryRepository.deleteById(category_id);
		return "The language was removed";
	}
	/********************Cities************************/
	@GetMapping("/AllCities")
	public @ResponseBody
	Iterable<City> getAllCities(){

		return cityRepository.findAll();
	}
	/********************Countries************************/
	@GetMapping("/AllCountries")
	public @ResponseBody
	Iterable<Country> getAllCountries(){

		return countryRepository.findAll();
	}
	/********************Films************************/

	@GetMapping("/OneFilm/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmByID(@PathVariable int film_id){

		return filmRepository.findById(film_id);
	}
	@PostMapping ("/AddFilms")
	public @ResponseBody String addFilm(@RequestParam String title, String description, int release_year, int language_id,
										int rental_duration, int length, String rating, int category_id){
		Film addFilm = new Film(title, description, release_year, language_id, rental_duration
				,length, rating, category_id);
		filmRepository.save(addFilm);
		return save;
	}
	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms(){

		return filmRepository.findAll();
	}
	@DeleteMapping("/DeleteFilms/{films_id}")
	public @ResponseBody
	String removeFilm(@PathVariable int films_id){
		filmRepository.deleteById(films_id);
		return "The film was removed";
	}
		@PutMapping("/updateFilms/{film_id}")
	public @ResponseBody
	String updateFilm(@PathVariable int film_id, @RequestParam String title, String description,
					  int release_year, int language_id,
					  int rental_duration, int length, String rating, int category_id){
		Film updateFilm= filmRepository.findById(film_id)
				.orElseThrow(() ->new ResourceNotFoundException("Film ID not found"));
		    updateFilm.setTitle(title);
		    updateFilm.setDescription(description);
			updateFilm.setRelease_year(release_year);
			updateFilm.setLanguage_id(language_id);
			updateFilm.setRental_duration(rental_duration);
			updateFilm.setLength(length);
			updateFilm.setRating(rating);
			updateFilm.setCategory_id(category_id);
		final Film updatedFilm = filmRepository.save(updateFilm);
		return updatedFilm.getTitle() + updatedFilm.getDescription() +
				updatedFilm.getRelease_year() + updatedFilm.getLanguage_id() +
				updatedFilm.getRental_duration() + updatedFilm.getLength() +
				updatedFilm.getRating();
	}
	/********************Languages**********************/

	@GetMapping("/OneLanguage/{language_id}")
	public @ResponseBody
	Optional<Language> getLanguageByID(@PathVariable int language_id){

		return languageRepository.findById(language_id);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/updateLanguage/{language_id}")
	public @ResponseBody
	String updateLanguage(@PathVariable int language_id, @RequestParam String name){
		Language updateLanguage = languageRepository.findById(language_id)
				.orElseThrow(() ->new ResourceNotFoundException("Language ID not found"));
		updateLanguage.setName(name);
		final Language updatedLanguage = languageRepository.save(updateLanguage);
		return updatedLanguage.getName();
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
