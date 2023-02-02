package br.com.netflics.utils;

import java.util.ArrayList;

import java.util.List;


import br.com.netflics.core.utils.DateUtil;

import br.com.netflics.json.JsonDepartment;
import br.com.netflics.model.Department;
import br.com.netflics.json.JsonMovie;
import br.com.netflics.model.Movie;
import br.com.netflics.json.JsonGenre;
import br.com.netflics.model.Genre;
import br.com.netflics.json.JsonMovieCast;
import br.com.netflics.model.MovieCast;
import br.com.netflics.json.JsonLanguage;
import br.com.netflics.model.Language;
import br.com.netflics.json.JsonCountry;
import br.com.netflics.model.Country;
import br.com.netflics.json.JsonKeyword;
import br.com.netflics.model.Keyword;
import br.com.netflics.json.JsonGender;
import br.com.netflics.model.Gender;
import br.com.netflics.json.JsonMovieCrew;
import br.com.netflics.model.MovieCrew;
import br.com.netflics.json.JsonCompany;
import br.com.netflics.model.Company;
import br.com.netflics.json.JsonPerson;
import br.com.netflics.model.Person;
import br.com.netflics.json.JsonUser;
import br.com.netflics.model.User;
import br.com.netflics.json.JsonRole;
import br.com.netflics.model.Role;
import br.com.netflics.json.JsonPermission;
import br.com.netflics.model.Permission;
import br.com.netflics.json.JsonGroup;
import br.com.netflics.model.Group;
import br.com.netflics.json.JsonItem;
import br.com.netflics.model.Item;
import br.com.netflics.model.User;
import br.com.netflics.json.JsonUser;

/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
public class Parser {

	//converte de entidade para json --------------------
	private static JsonDepartment toBasicJson(Department department) {
		JsonDepartment jsonDepartment = new JsonDepartment();
		applyBasicJsonValues(jsonDepartment, department);
		return jsonDepartment;
	}
	
	private static Department toBasicEntity(JsonDepartment jsonDepartment) {
		Department department = new Department();
		applyBasicEntityValues(department, jsonDepartment);
		return department;
	}
	
	private static void applyBasicJsonValues(JsonDepartment jsonDepartment, Department department) {
		jsonDepartment.setId(department.getId());
	    jsonDepartment.setDepartmentName(department.getDepartmentName());
	}	
	private static void applyBasicEntityValues(Department department, JsonDepartment jsonDepartment) {
		department.setId(jsonDepartment.getId());
		department.setDepartmentName(jsonDepartment.getDepartmentName());
	}	
	
	public static JsonDepartment toJson(Department department) {
		if(department == null){
			return null;
		}
		
		JsonDepartment jsonDepartment = new JsonDepartment();
		
		applyBasicJsonValues(jsonDepartment, department);

		return jsonDepartment;
	}


	public static Department apply(Department department, JsonDepartment jsonDepartment) {
	
		if(department ==  null)
			department = new Department();
		
		applyBasicEntityValues(department, jsonDepartment) ;

		return department;
		
	}		
	public static Department toEntity(JsonDepartment jsonDepartment) {
		Department department = new Department();
		
		return apply(department, jsonDepartment);
	}		
	
	public static List<JsonDepartment> toListJsonDepartments(List<Department> all) {
		List<JsonDepartment> jsonDepartments = new ArrayList<JsonDepartment>();
		for (Department department : all) {
			jsonDepartments.add(toJson(department));
		}
		return jsonDepartments;
	}
	//converte de entidade para json --------------------
	private static JsonMovie toBasicJson(Movie movie) {
		JsonMovie jsonMovie = new JsonMovie();
		applyBasicJsonValues(jsonMovie, movie);
		return jsonMovie;
	}
	
	private static Movie toBasicEntity(JsonMovie jsonMovie) {
		Movie movie = new Movie();
		applyBasicEntityValues(movie, jsonMovie);
		return movie;
	}
	
	private static void applyBasicJsonValues(JsonMovie jsonMovie, Movie movie) {
		jsonMovie.setId(movie.getId());
	    jsonMovie.setTitle(movie.getTitle());
	    jsonMovie.setBudget(movie.getBudget());
	    jsonMovie.setHomepage(movie.getHomepage());
	    jsonMovie.setOverview(movie.getOverview());
	    jsonMovie.setPopularity(movie.getPopularity());
	    jsonMovie.setReleaseDate(movie.getReleaseDate());
	    jsonMovie.setRevenue(movie.getRevenue());
	    jsonMovie.setRuntime(movie.getRuntime());
	    jsonMovie.setStatus(movie.getStatus());
	    jsonMovie.setTagline(movie.getTagline());
	    jsonMovie.setVoteAverage(movie.getVoteAverage());
	    jsonMovie.setVoteCount(movie.getVoteCount());
	}	
	private static void applyBasicEntityValues(Movie movie, JsonMovie jsonMovie) {
		movie.setId(jsonMovie.getId());
		movie.setTitle(jsonMovie.getTitle());
		movie.setBudget(jsonMovie.getBudget());
		movie.setHomepage(jsonMovie.getHomepage());
		movie.setOverview(jsonMovie.getOverview());
		movie.setPopularity(jsonMovie.getPopularity());
		movie.setReleaseDate(jsonMovie.getReleaseDate());
		movie.setRevenue(jsonMovie.getRevenue());
		movie.setRuntime(jsonMovie.getRuntime());
		movie.setStatus(jsonMovie.getStatus());
		movie.setTagline(jsonMovie.getTagline());
		movie.setVoteAverage(jsonMovie.getVoteAverage());
		movie.setVoteCount(jsonMovie.getVoteCount());
	}	
	
	public static JsonMovie toJson(Movie movie) {
		if(movie == null){
			return null;
		}
		
		JsonMovie jsonMovie = new JsonMovie();
		
		applyBasicJsonValues(jsonMovie, movie);

		List<Language> listLanguages = movie.getLanguages();
		if (listLanguages != null) {
			for (Language loopLanguage : listLanguages) {
				jsonMovie.getLanguages().add(toBasicJson(loopLanguage));
			}
		}			

		List<Country> listCountries = movie.getCountries();
		if (listCountries != null) {
			for (Country loopCountry : listCountries) {
				jsonMovie.getCountries().add(toJson(loopCountry));
			}
		}			

		List<Keyword> listKeywords = movie.getKeywords();
		if (listKeywords != null) {
			for (Keyword loopKeyword : listKeywords) {
				jsonMovie.getKeywords().add(toBasicJson(loopKeyword));
			}
		}			

		List<MovieCrew> listCrew = movie.getCrew();
		if (listCrew != null) {
			for (MovieCrew loopMovieCrew : listCrew) {
				jsonMovie.getCrew().add(toJson(loopMovieCrew));
			}
		}
		List<MovieCast> listCast = movie.getCast();
		if (listCast != null) {
			for (MovieCast loopMovieCast : listCast) {
				jsonMovie.getCast().add(toJson(loopMovieCast));
			}
		}
		List<Genre> listGenres = movie.getGenres();
		if (listGenres != null) {
			for (Genre loopGenre : listGenres) {
				jsonMovie.getGenres().add(toJson(loopGenre));
			}
		}			

		List<Company> listCompany = movie.getCompany();
		if (listCompany != null) {
			for (Company loopCompany : listCompany) {
				jsonMovie.getCompany().add(toJson(loopCompany));
			}
		}			

		return jsonMovie;
	}


	public static Movie apply(Movie movie, JsonMovie jsonMovie) {
	
		if(movie ==  null)
			movie = new Movie();
		
		applyBasicEntityValues(movie, jsonMovie) ;

		ArrayList<JsonLanguage> listLanguages = jsonMovie.getLanguages();			
		if (listLanguages != null) {
			for (JsonLanguage loopJsonLanguage : listLanguages) {
				movie.addLanguages(toBasicEntity(loopJsonLanguage));
			}
		}
			
		ArrayList<JsonCountry> listCountries = jsonMovie.getCountries();			
		if (listCountries != null) {
			for (JsonCountry loopJsonCountry : listCountries) {
				movie.addCountries(toBasicEntity(loopJsonCountry));
			}
		}
			
		ArrayList<JsonKeyword> listKeywords = jsonMovie.getKeywords();			
		if (listKeywords != null) {
			for (JsonKeyword loopJsonKeyword : listKeywords) {
				movie.addKeywords(toBasicEntity(loopJsonKeyword));
			}
		}
			
		ArrayList<JsonMovieCrew> listCrew = jsonMovie.getCrew();
		if (listCrew != null) {
			for (JsonMovieCrew loopJsonMovieCrew : listCrew) {
				movie.addCrew(toBasicEntity(loopJsonMovieCrew));
			}
		}
					
		ArrayList<JsonMovieCast> listCast = jsonMovie.getCast();
		if (listCast != null) {
			for (JsonMovieCast loopJsonMovieCast : listCast) {
				movie.addCast(toBasicEntity(loopJsonMovieCast));
			}
		}
					
		ArrayList<JsonGenre> listGenres = jsonMovie.getGenres();			
		if (listGenres != null) {
			for (JsonGenre loopJsonGenre : listGenres) {
				movie.addGenres(toBasicEntity(loopJsonGenre));
			}
		}
			
		ArrayList<JsonCompany> listCompany = jsonMovie.getCompany();			
		if (listCompany != null) {
			for (JsonCompany loopJsonCompany : listCompany) {
				movie.addCompany(toBasicEntity(loopJsonCompany));
			}
		}
			
		return movie;
		
	}		
	public static Movie toEntity(JsonMovie jsonMovie) {
		Movie movie = new Movie();
		
		return apply(movie, jsonMovie);
	}		
	
	public static List<JsonMovie> toListJsonMovies(List<Movie> all) {
		List<JsonMovie> jsonMovies = new ArrayList<JsonMovie>();
		for (Movie movie : all) {
			jsonMovies.add(toJson(movie));
		}
		return jsonMovies;
	}
	//converte de entidade para json --------------------
	private static JsonGenre toBasicJson(Genre genre) {
		JsonGenre jsonGenre = new JsonGenre();
		applyBasicJsonValues(jsonGenre, genre);
		return jsonGenre;
	}
	
	private static Genre toBasicEntity(JsonGenre jsonGenre) {
		Genre genre = new Genre();
		applyBasicEntityValues(genre, jsonGenre);
		return genre;
	}
	
	private static void applyBasicJsonValues(JsonGenre jsonGenre, Genre genre) {
		jsonGenre.setId(genre.getId());
	    jsonGenre.setGenreName(genre.getGenreName());
	}	
	private static void applyBasicEntityValues(Genre genre, JsonGenre jsonGenre) {
		genre.setId(jsonGenre.getId());
		genre.setGenreName(jsonGenre.getGenreName());
	}	
	
	public static JsonGenre toJson(Genre genre) {
		if(genre == null){
			return null;
		}
		
		JsonGenre jsonGenre = new JsonGenre();
		
		applyBasicJsonValues(jsonGenre, genre);

		return jsonGenre;
	}


	public static Genre apply(Genre genre, JsonGenre jsonGenre) {
	
		if(genre ==  null)
			genre = new Genre();
		
		applyBasicEntityValues(genre, jsonGenre) ;

		return genre;
		
	}		
	public static Genre toEntity(JsonGenre jsonGenre) {
		Genre genre = new Genre();
		
		return apply(genre, jsonGenre);
	}		
	
	public static List<JsonGenre> toListJsonGenres(List<Genre> all) {
		List<JsonGenre> jsonGenres = new ArrayList<JsonGenre>();
		for (Genre genre : all) {
			jsonGenres.add(toJson(genre));
		}
		return jsonGenres;
	}
	//converte de entidade para json --------------------
	private static JsonMovieCast toBasicJson(MovieCast movieCast) {
		JsonMovieCast jsonMovieCast = new JsonMovieCast();
		applyBasicJsonValues(jsonMovieCast, movieCast);
		return jsonMovieCast;
	}
	
	private static MovieCast toBasicEntity(JsonMovieCast jsonMovieCast) {
		MovieCast movieCast = new MovieCast();
		applyBasicEntityValues(movieCast, jsonMovieCast);
		return movieCast;
	}
	
	private static void applyBasicJsonValues(JsonMovieCast jsonMovieCast, MovieCast movieCast) {
		jsonMovieCast.setId(movieCast.getId());
	    jsonMovieCast.setOrder(movieCast.getOrder());
	    jsonMovieCast.setCharacterName(movieCast.getCharacterName());
	}	
	private static void applyBasicEntityValues(MovieCast movieCast, JsonMovieCast jsonMovieCast) {
		movieCast.setId(jsonMovieCast.getId());
		movieCast.setOrder(jsonMovieCast.getOrder());
		movieCast.setCharacterName(jsonMovieCast.getCharacterName());
	}	
	
	public static JsonMovieCast toJson(MovieCast movieCast) {
		if(movieCast == null){
			return null;
		}
		
		JsonMovieCast jsonMovieCast = new JsonMovieCast();
		
		applyBasicJsonValues(jsonMovieCast, movieCast);

//		Movie movie_ = movieCast.getMovie();
//		if (movie_ != null) {
//			jsonMovieCast.setMovie(toBasicJson(movie_));
//		}
		Gender gender_ = movieCast.getGender();
		if (gender_ != null) {
			jsonMovieCast.setGender(toBasicJson(gender_));
		}
		Person person_ = movieCast.getPerson();
		if (person_ != null) {
			jsonMovieCast.setPerson(toBasicJson(person_));
		}
		return jsonMovieCast;
	}


	public static MovieCast apply(MovieCast movieCast, JsonMovieCast jsonMovieCast) {
	
		if(movieCast ==  null)
			movieCast = new MovieCast();
		
		applyBasicEntityValues(movieCast, jsonMovieCast) ;

		JsonMovie movie_ = jsonMovieCast.getMovie();
		if (movie_ != null) {
			movieCast.setMovie(toBasicEntity(movie_));
		}	
		JsonGender gender_ = jsonMovieCast.getGender();
		if (gender_ != null) {
			movieCast.setGender(toBasicEntity(gender_));
		}	
		JsonPerson person_ = jsonMovieCast.getPerson();
		if (person_ != null) {
			movieCast.setPerson(toBasicEntity(person_));
		}	
		return movieCast;
		
	}		
	public static MovieCast toEntity(JsonMovieCast jsonMovieCast) {
		MovieCast movieCast = new MovieCast();
		
		return apply(movieCast, jsonMovieCast);
	}		
	
	public static List<JsonMovieCast> toListJsonMovieCasts(List<MovieCast> all) {
		List<JsonMovieCast> jsonMovieCasts = new ArrayList<JsonMovieCast>();
		for (MovieCast movieCast : all) {
			jsonMovieCasts.add(toJson(movieCast));
		}
		return jsonMovieCasts;
	}
	//converte de entidade para json --------------------
	private static JsonLanguage toBasicJson(Language language) {
		JsonLanguage jsonLanguage = new JsonLanguage();
		applyBasicJsonValues(jsonLanguage, language);
		return jsonLanguage;
	}
	
	private static Language toBasicEntity(JsonLanguage jsonLanguage) {
		Language language = new Language();
		applyBasicEntityValues(language, jsonLanguage);
		return language;
	}
	
	private static void applyBasicJsonValues(JsonLanguage jsonLanguage, Language language) {
		jsonLanguage.setId(language.getId());
	    jsonLanguage.setCode(language.getCode());
	    jsonLanguage.setName(language.getName());
	}	
	private static void applyBasicEntityValues(Language language, JsonLanguage jsonLanguage) {
		language.setId(jsonLanguage.getId());
		language.setCode(jsonLanguage.getCode());
		language.setName(jsonLanguage.getName());
	}	
	
	public static JsonLanguage toJson(Language language) {
		if(language == null){
			return null;
		}
		
		JsonLanguage jsonLanguage = new JsonLanguage();
		
		applyBasicJsonValues(jsonLanguage, language);

		return jsonLanguage;
	}


	public static Language apply(Language language, JsonLanguage jsonLanguage) {
	
		if(language ==  null)
			language = new Language();
		
		applyBasicEntityValues(language, jsonLanguage) ;

		return language;
		
	}		
	public static Language toEntity(JsonLanguage jsonLanguage) {
		Language language = new Language();
		
		return apply(language, jsonLanguage);
	}		
	
	public static List<JsonLanguage> toListJsonLanguages(List<Language> all) {
		List<JsonLanguage> jsonLanguages = new ArrayList<JsonLanguage>();
		for (Language language : all) {
			jsonLanguages.add(toJson(language));
		}
		return jsonLanguages;
	}
	//converte de entidade para json --------------------
	private static JsonCountry toBasicJson(Country country) {
		JsonCountry jsonCountry = new JsonCountry();
		applyBasicJsonValues(jsonCountry, country);
		return jsonCountry;
	}
	
	private static Country toBasicEntity(JsonCountry jsonCountry) {
		Country country = new Country();
		applyBasicEntityValues(country, jsonCountry);
		return country;
	}
	
	private static void applyBasicJsonValues(JsonCountry jsonCountry, Country country) {
		jsonCountry.setId(country.getId());
	    jsonCountry.setName(country.getName());
	    jsonCountry.setIsoCode(country.getIsoCode());
	}	
	private static void applyBasicEntityValues(Country country, JsonCountry jsonCountry) {
		country.setId(jsonCountry.getId());
		country.setName(jsonCountry.getName());
		country.setIsoCode(jsonCountry.getIsoCode());
	}	
	
	public static JsonCountry toJson(Country country) {
		if(country == null){
			return null;
		}
		
		JsonCountry jsonCountry = new JsonCountry();
		
		applyBasicJsonValues(jsonCountry, country);

		List<Movie> listMovies = country.getMovies();
		if (listMovies != null) {
			for (Movie loopMovie : listMovies) {
				jsonCountry.getMovies().add(toBasicJson(loopMovie));
			}
		}			

		return jsonCountry;
	}


	public static Country apply(Country country, JsonCountry jsonCountry) {
	
		if(country ==  null)
			country = new Country();
		
		applyBasicEntityValues(country, jsonCountry) ;

		ArrayList<JsonMovie> listMovies = jsonCountry.getMovies();			
		if (listMovies != null) {
			for (JsonMovie loopJsonMovie : listMovies) {
				country.addMovies(toBasicEntity(loopJsonMovie));
			}
		}
			
		return country;
		
	}		
	public static Country toEntity(JsonCountry jsonCountry) {
		Country country = new Country();
		
		return apply(country, jsonCountry);
	}		
	
	public static List<JsonCountry> toListJsonCountrys(List<Country> all) {
		List<JsonCountry> jsonCountrys = new ArrayList<JsonCountry>();
		for (Country country : all) {
			jsonCountrys.add(toJson(country));
		}
		return jsonCountrys;
	}
	//converte de entidade para json --------------------
	private static JsonKeyword toBasicJson(Keyword keyword) {
		JsonKeyword jsonKeyword = new JsonKeyword();
		applyBasicJsonValues(jsonKeyword, keyword);
		return jsonKeyword;
	}
	
	private static Keyword toBasicEntity(JsonKeyword jsonKeyword) {
		Keyword keyword = new Keyword();
		applyBasicEntityValues(keyword, jsonKeyword);
		return keyword;
	}
	
	private static void applyBasicJsonValues(JsonKeyword jsonKeyword, Keyword keyword) {
		jsonKeyword.setId(keyword.getId());
	    jsonKeyword.setName(keyword.getName());
	}	
	private static void applyBasicEntityValues(Keyword keyword, JsonKeyword jsonKeyword) {
		keyword.setId(jsonKeyword.getId());
		keyword.setName(jsonKeyword.getName());
	}	
	
	public static JsonKeyword toJson(Keyword keyword) {
		if(keyword == null){
			return null;
		}
		
		JsonKeyword jsonKeyword = new JsonKeyword();
		
		applyBasicJsonValues(jsonKeyword, keyword);

		List<Movie> listMovies = keyword.getMovies();
		if (listMovies != null) {
			for (Movie loopMovie : listMovies) {
				jsonKeyword.getMovies().add(toBasicJson(loopMovie));
			}
		}			

		return jsonKeyword;
	}


	public static Keyword apply(Keyword keyword, JsonKeyword jsonKeyword) {
	
		if(keyword ==  null)
			keyword = new Keyword();
		
		applyBasicEntityValues(keyword, jsonKeyword) ;

		ArrayList<JsonMovie> listMovies = jsonKeyword.getMovies();			
		if (listMovies != null) {
			for (JsonMovie loopJsonMovie : listMovies) {
				keyword.addMovies(toBasicEntity(loopJsonMovie));
			}
		}
			
		return keyword;
		
	}		
	public static Keyword toEntity(JsonKeyword jsonKeyword) {
		Keyword keyword = new Keyword();
		
		return apply(keyword, jsonKeyword);
	}		
	
	public static List<JsonKeyword> toListJsonKeywords(List<Keyword> all) {
		List<JsonKeyword> jsonKeywords = new ArrayList<JsonKeyword>();
		for (Keyword keyword : all) {
			jsonKeywords.add(toJson(keyword));
		}
		return jsonKeywords;
	}
	//converte de entidade para json --------------------
	private static JsonGender toBasicJson(Gender gender) {
		JsonGender jsonGender = new JsonGender();
		applyBasicJsonValues(jsonGender, gender);
		return jsonGender;
	}
	
	private static Gender toBasicEntity(JsonGender jsonGender) {
		Gender gender = new Gender();
		applyBasicEntityValues(gender, jsonGender);
		return gender;
	}
	
	private static void applyBasicJsonValues(JsonGender jsonGender, Gender gender) {
		jsonGender.setId(gender.getId());
	    jsonGender.setGender(gender.getGender());
	}	
	private static void applyBasicEntityValues(Gender gender, JsonGender jsonGender) {
		gender.setId(jsonGender.getId());
		gender.setGender(jsonGender.getGender());
	}	
	
	public static JsonGender toJson(Gender gender) {
		if(gender == null){
			return null;
		}
		
		JsonGender jsonGender = new JsonGender();
		
		applyBasicJsonValues(jsonGender, gender);

		return jsonGender;
	}


	public static Gender apply(Gender gender, JsonGender jsonGender) {
	
		if(gender ==  null)
			gender = new Gender();
		
		applyBasicEntityValues(gender, jsonGender) ;

		return gender;
		
	}		
	public static Gender toEntity(JsonGender jsonGender) {
		Gender gender = new Gender();
		
		return apply(gender, jsonGender);
	}		
	
	public static List<JsonGender> toListJsonGenders(List<Gender> all) {
		List<JsonGender> jsonGenders = new ArrayList<JsonGender>();
		for (Gender gender : all) {
			jsonGenders.add(toJson(gender));
		}
		return jsonGenders;
	}
	//converte de entidade para json --------------------
	private static JsonMovieCrew toBasicJson(MovieCrew movieCrew) {
		JsonMovieCrew jsonMovieCrew = new JsonMovieCrew();
		applyBasicJsonValues(jsonMovieCrew, movieCrew);
		return jsonMovieCrew;
	}
	
	private static MovieCrew toBasicEntity(JsonMovieCrew jsonMovieCrew) {
		MovieCrew movieCrew = new MovieCrew();
		applyBasicEntityValues(movieCrew, jsonMovieCrew);
		return movieCrew;
	}
	
	private static void applyBasicJsonValues(JsonMovieCrew jsonMovieCrew, MovieCrew movieCrew) {
		jsonMovieCrew.setId(movieCrew.getId());
	    jsonMovieCrew.setJob(movieCrew.getJob());
	}	
	private static void applyBasicEntityValues(MovieCrew movieCrew, JsonMovieCrew jsonMovieCrew) {
		movieCrew.setId(jsonMovieCrew.getId());
		movieCrew.setJob(jsonMovieCrew.getJob());
	}	
	
	public static JsonMovieCrew toJson(MovieCrew movieCrew) {
		if(movieCrew == null){
			return null;
		}
		
		JsonMovieCrew jsonMovieCrew = new JsonMovieCrew();
		
		applyBasicJsonValues(jsonMovieCrew, movieCrew);

//		Movie movie_ = movieCrew.getMovie();
//		if (movie_ != null) {
//			jsonMovieCrew.setMovie(toBasicJson(movie_));
//		}
		Person person_ = movieCrew.getPerson();
		if (person_ != null) {
			jsonMovieCrew.setPerson(toBasicJson(person_));
		}
		Department department_ = movieCrew.getDepartment();
		if (department_ != null) {
			jsonMovieCrew.setDepartment(toBasicJson(department_));
		}
		return jsonMovieCrew;
	}


	public static MovieCrew apply(MovieCrew movieCrew, JsonMovieCrew jsonMovieCrew) {
	
		if(movieCrew ==  null)
			movieCrew = new MovieCrew();
		
		applyBasicEntityValues(movieCrew, jsonMovieCrew) ;

		JsonMovie movie_ = jsonMovieCrew.getMovie();
		if (movie_ != null) {
			movieCrew.setMovie(toBasicEntity(movie_));
		}	
		JsonPerson person_ = jsonMovieCrew.getPerson();
		if (person_ != null) {
			movieCrew.setPerson(toBasicEntity(person_));
		}	
		JsonDepartment department_ = jsonMovieCrew.getDepartment();
		if (department_ != null) {
			movieCrew.setDepartment(toBasicEntity(department_));
		}	
		return movieCrew;
		
	}		
	public static MovieCrew toEntity(JsonMovieCrew jsonMovieCrew) {
		MovieCrew movieCrew = new MovieCrew();
		
		return apply(movieCrew, jsonMovieCrew);
	}		
	
	public static List<JsonMovieCrew> toListJsonMovieCrews(List<MovieCrew> all) {
		List<JsonMovieCrew> jsonMovieCrews = new ArrayList<JsonMovieCrew>();
		for (MovieCrew movieCrew : all) {
			jsonMovieCrews.add(toJson(movieCrew));
		}
		return jsonMovieCrews;
	}
	//converte de entidade para json --------------------
	private static JsonCompany toBasicJson(Company company) {
		JsonCompany jsonCompany = new JsonCompany();
		applyBasicJsonValues(jsonCompany, company);
		return jsonCompany;
	}
	
	private static Company toBasicEntity(JsonCompany jsonCompany) {
		Company company = new Company();
		applyBasicEntityValues(company, jsonCompany);
		return company;
	}
	
	private static void applyBasicJsonValues(JsonCompany jsonCompany, Company company) {
		jsonCompany.setId(company.getId());
	    jsonCompany.setName(company.getName());
	}	
	private static void applyBasicEntityValues(Company company, JsonCompany jsonCompany) {
		company.setId(jsonCompany.getId());
		company.setName(jsonCompany.getName());
	}	
	
	public static JsonCompany toJson(Company company) {
		if(company == null){
			return null;
		}
		
		JsonCompany jsonCompany = new JsonCompany();
		
		applyBasicJsonValues(jsonCompany, company);

		List<Movie> listMovies = company.getMovies();
		if (listMovies != null) {
			for (Movie loopMovie : listMovies) {
				jsonCompany.getMovies().add(toBasicJson(loopMovie));
			}
		}			

		return jsonCompany;
	}


	public static Company apply(Company company, JsonCompany jsonCompany) {
	
		if(company ==  null)
			company = new Company();
		
		applyBasicEntityValues(company, jsonCompany) ;

		ArrayList<JsonMovie> listMovies = jsonCompany.getMovies();			
		if (listMovies != null) {
			for (JsonMovie loopJsonMovie : listMovies) {
				company.addMovies(toBasicEntity(loopJsonMovie));
			}
		}
			
		return company;
		
	}		
	public static Company toEntity(JsonCompany jsonCompany) {
		Company company = new Company();
		
		return apply(company, jsonCompany);
	}		
	
	public static List<JsonCompany> toListJsonCompanys(List<Company> all) {
		List<JsonCompany> jsonCompanys = new ArrayList<JsonCompany>();
		for (Company company : all) {
			jsonCompanys.add(toJson(company));
		}
		return jsonCompanys;
	}
	//converte de entidade para json --------------------
	private static JsonPerson toBasicJson(Person person) {
		JsonPerson jsonPerson = new JsonPerson();
		applyBasicJsonValues(jsonPerson, person);
		return jsonPerson;
	}
	
	private static Person toBasicEntity(JsonPerson jsonPerson) {
		Person person = new Person();
		applyBasicEntityValues(person, jsonPerson);
		return person;
	}
	
	private static void applyBasicJsonValues(JsonPerson jsonPerson, Person person) {
		jsonPerson.setId(person.getId());
	    jsonPerson.setName(person.getName());
	}	
	private static void applyBasicEntityValues(Person person, JsonPerson jsonPerson) {
		person.setId(jsonPerson.getId());
		person.setName(jsonPerson.getName());
	}	
	
	public static JsonPerson toJson(Person person) {
		if(person == null){
			return null;
		}
		
		JsonPerson jsonPerson = new JsonPerson();
		
		applyBasicJsonValues(jsonPerson, person);

		return jsonPerson;
	}


	public static Person apply(Person person, JsonPerson jsonPerson) {
	
		if(person ==  null)
			person = new Person();
		
		applyBasicEntityValues(person, jsonPerson) ;

		return person;
		
	}		
	public static Person toEntity(JsonPerson jsonPerson) {
		Person person = new Person();
		
		return apply(person, jsonPerson);
	}		
	
	public static List<JsonPerson> toListJsonPersons(List<Person> all) {
		List<JsonPerson> jsonPersons = new ArrayList<JsonPerson>();
		for (Person person : all) {
			jsonPersons.add(toJson(person));
		}
		return jsonPersons;
	}
	//converte de entidade para json --------------------
	private static JsonUser toBasicJson(User user) {
		JsonUser jsonUser = new JsonUser();
		applyBasicJsonValues(jsonUser, user);
		return jsonUser;
	}
	
	private static User toBasicEntity(JsonUser jsonUser) {
		User user = new User();
		applyBasicEntityValues(user, jsonUser);
		return user;
	}
	
	private static void applyBasicJsonValues(JsonUser jsonUser, User user) {
		jsonUser.setId(user.getId());
	    jsonUser.setName(user.getName());
	    jsonUser.setUsername(user.getUsername());
	    jsonUser.setEmail(user.getEmail());
	    jsonUser.setPassword(user.getPassword());
	    jsonUser.setEnable(user.getEnable());
	    jsonUser.setImage(user.getImage());
	}	
	private static void applyBasicEntityValues(User user, JsonUser jsonUser) {
		user.setId(jsonUser.getId());
		user.setName(jsonUser.getName());
		user.setUsername(jsonUser.getUsername());
		user.setEmail(jsonUser.getEmail());
		user.setPassword(jsonUser.getPassword());
		user.setEnable(jsonUser.getEnable());
		user.setImage(jsonUser.getImage());
	}	
	
	public static JsonUser toJson(User user) {
		if(user == null){
			return null;
		}
		
		JsonUser jsonUser = new JsonUser();
		
		applyBasicJsonValues(jsonUser, user);

		List<Role> listRoles = user.getRoles();
		if (listRoles != null) {
			for (Role loopRole : listRoles) {
				jsonUser.getRoles().add(toBasicJson(loopRole));
			}
		}

		return jsonUser;
	}


	public static User apply(User user, JsonUser jsonUser) {
	
		if(user ==  null)
			user = new User();
		
		applyBasicEntityValues(user, jsonUser) ;

		ArrayList<JsonRole> listRoles = jsonUser.getRoles();			
		if (listRoles != null) {
			for (JsonRole loopJsonRole : listRoles) {
				user.addRoles(toBasicEntity(loopJsonRole));
			}
		}
		return user;
		
	}		
	public static User toEntity(JsonUser jsonUser) {
		User user = new User();
		
		return apply(user, jsonUser);
	}		
	
	public static List<JsonUser> toListJsonUsers(List<User> all) {
		List<JsonUser> jsonUsers = new ArrayList<JsonUser>();
		for (User user : all) {
			jsonUsers.add(toJson(user));
		}
		return jsonUsers;
	}
	//converte de entidade para json --------------------
	private static JsonRole toBasicJson(Role role) {
		JsonRole jsonRole = new JsonRole();
		applyBasicJsonValues(jsonRole, role);
		return jsonRole;
	}
	
	private static Role toBasicEntity(JsonRole jsonRole) {
		Role role = new Role();
		applyBasicEntityValues(role, jsonRole);
		return role;
	}
	
	private static void applyBasicJsonValues(JsonRole jsonRole, Role role) {
		jsonRole.setId(role.getId());
	    jsonRole.setAuthority(role.getAuthority());
	    jsonRole.setDescription(role.getDescription());
	}	
	private static void applyBasicEntityValues(Role role, JsonRole jsonRole) {
		role.setId(jsonRole.getId());
		role.setAuthority(jsonRole.getAuthority());
		role.setDescription(jsonRole.getDescription());
	}	
	
	public static JsonRole toJson(Role role) {
		if(role == null){
			return null;
		}
		
		JsonRole jsonRole = new JsonRole();
		
		applyBasicJsonValues(jsonRole, role);

		List<User> listUsers = role.getUsers();
		if (listUsers != null) {
			for (User loopUser : listUsers) {
				jsonRole.getUsers().add(toBasicJson(loopUser));
			}
		}			

		List<Permission> listPermissions = role.getPermissions();
		if (listPermissions != null) {
			for (Permission loopPermission : listPermissions) {
				jsonRole.getPermissions().add(toBasicJson(loopPermission));
			}
		}

		List<Group> listGroups = role.getGroups();
		if (listGroups != null) {
			for (Group loopGroup : listGroups) {
				jsonRole.getGroups().add(toBasicJson(loopGroup));
			}
		}

		return jsonRole;
	}


	public static Role apply(Role role, JsonRole jsonRole) {
	
		if(role ==  null)
			role = new Role();
		
		applyBasicEntityValues(role, jsonRole) ;

		ArrayList<JsonUser> listUsers = jsonRole.getUsers();			
		if (listUsers != null) {
			for (JsonUser loopJsonUser : listUsers) {
				role.addUsers(toBasicEntity(loopJsonUser));
			}
		}
			
		ArrayList<JsonPermission> listPermissions = jsonRole.getPermissions();			
		if (listPermissions != null) {
			for (JsonPermission loopJsonPermission : listPermissions) {
				role.addPermissions(toBasicEntity(loopJsonPermission));
			}
		}
		ArrayList<JsonGroup> listGroups = jsonRole.getGroups();			
		if (listGroups != null) {
			for (JsonGroup loopJsonGroup : listGroups) {
				role.addGroups(toBasicEntity(loopJsonGroup));
			}
		}
		return role;
		
	}		
	public static Role toEntity(JsonRole jsonRole) {
		Role role = new Role();
		
		return apply(role, jsonRole);
	}		
	
	public static List<JsonRole> toListJsonRoles(List<Role> all) {
		List<JsonRole> jsonRoles = new ArrayList<JsonRole>();
		for (Role role : all) {
			jsonRoles.add(toJson(role));
		}
		return jsonRoles;
	}
	//converte de entidade para json --------------------
	private static JsonPermission toBasicJson(Permission permission) {
		JsonPermission jsonPermission = new JsonPermission();
		applyBasicJsonValues(jsonPermission, permission);
		return jsonPermission;
	}
	
	private static Permission toBasicEntity(JsonPermission jsonPermission) {
		Permission permission = new Permission();
		applyBasicEntityValues(permission, jsonPermission);
		return permission;
	}
	
	private static void applyBasicJsonValues(JsonPermission jsonPermission, Permission permission) {
		jsonPermission.setId(permission.getId());
	    jsonPermission.setName(permission.getName());
	    jsonPermission.setDescription(permission.getDescription());
	    jsonPermission.setOperation(permission.getOperation());
	    jsonPermission.setTagReminder(permission.getTagReminder());
	}	
	private static void applyBasicEntityValues(Permission permission, JsonPermission jsonPermission) {
		permission.setId(jsonPermission.getId());
		permission.setName(jsonPermission.getName());
		permission.setDescription(jsonPermission.getDescription());
		permission.setOperation(jsonPermission.getOperation());
		permission.setTagReminder(jsonPermission.getTagReminder());
	}	
	
	public static JsonPermission toJson(Permission permission) {
		if(permission == null){
			return null;
		}
		
		JsonPermission jsonPermission = new JsonPermission();
		
		applyBasicJsonValues(jsonPermission, permission);

		List<Role> listRoles = permission.getRoles();
		if (listRoles != null) {
			for (Role loopRole : listRoles) {
				jsonPermission.getRoles().add(toBasicJson(loopRole));
			}
		}			

		List<Group> listGroups = permission.getGroups();
		if (listGroups != null) {
			for (Group loopGroup : listGroups) {
				jsonPermission.getGroups().add(toBasicJson(loopGroup));
			}
		}			

		Item item_ = permission.getItem();
		if (item_ != null) {
			jsonPermission.setItem(toBasicJson(item_));
		}
		return jsonPermission;
	}


	public static Permission apply(Permission permission, JsonPermission jsonPermission) {
	
		if(permission ==  null)
			permission = new Permission();
		
		applyBasicEntityValues(permission, jsonPermission) ;

		ArrayList<JsonRole> listRoles = jsonPermission.getRoles();			
		if (listRoles != null) {
			for (JsonRole loopJsonRole : listRoles) {
				permission.addRoles(toBasicEntity(loopJsonRole));
			}
		}
			
		ArrayList<JsonGroup> listGroups = jsonPermission.getGroups();			
		if (listGroups != null) {
			for (JsonGroup loopJsonGroup : listGroups) {
				permission.addGroups(toBasicEntity(loopJsonGroup));
			}
		}
			
		JsonItem item_ = jsonPermission.getItem();
		if (item_ != null) {
			permission.setItem(toBasicEntity(item_));
		}	
		return permission;
		
	}		
	public static Permission toEntity(JsonPermission jsonPermission) {
		Permission permission = new Permission();
		
		return apply(permission, jsonPermission);
	}		
	
	public static List<JsonPermission> toListJsonPermissions(List<Permission> all) {
		List<JsonPermission> jsonPermissions = new ArrayList<JsonPermission>();
		for (Permission permission : all) {
			jsonPermissions.add(toJson(permission));
		}
		return jsonPermissions;
	}
	//converte de entidade para json --------------------
	private static JsonGroup toBasicJson(Group group) {
		JsonGroup jsonGroup = new JsonGroup();
		applyBasicJsonValues(jsonGroup, group);
		return jsonGroup;
	}
	
	private static Group toBasicEntity(JsonGroup jsonGroup) {
		Group group = new Group();
		applyBasicEntityValues(group, jsonGroup);
		return group;
	}
	
	private static void applyBasicJsonValues(JsonGroup jsonGroup, Group group) {
		jsonGroup.setId(group.getId());
	    jsonGroup.setName(group.getName());
	    jsonGroup.setDescription(group.getDescription());
	}	
	private static void applyBasicEntityValues(Group group, JsonGroup jsonGroup) {
		group.setId(jsonGroup.getId());
		group.setName(jsonGroup.getName());
		group.setDescription(jsonGroup.getDescription());
	}	
	
	public static JsonGroup toJson(Group group) {
		if(group == null){
			return null;
		}
		
		JsonGroup jsonGroup = new JsonGroup();
		
		applyBasicJsonValues(jsonGroup, group);

		List<Role> listRoles = group.getRoles();
		if (listRoles != null) {
			for (Role loopRole : listRoles) {
				jsonGroup.getRoles().add(toBasicJson(loopRole));
			}
		}			

		List<Permission> listPermissions = group.getPermissions();
		if (listPermissions != null) {
			for (Permission loopPermission : listPermissions) {
				jsonGroup.getPermissions().add(toBasicJson(loopPermission));
			}
		}

		return jsonGroup;
	}


	public static Group apply(Group group, JsonGroup jsonGroup) {
	
		if(group ==  null)
			group = new Group();
		
		applyBasicEntityValues(group, jsonGroup) ;

		ArrayList<JsonRole> listRoles = jsonGroup.getRoles();			
		if (listRoles != null) {
			for (JsonRole loopJsonRole : listRoles) {
				group.addRoles(toBasicEntity(loopJsonRole));
			}
		}
			
		ArrayList<JsonPermission> listPermissions = jsonGroup.getPermissions();			
		if (listPermissions != null) {
			for (JsonPermission loopJsonPermission : listPermissions) {
				group.addPermissions(toBasicEntity(loopJsonPermission));
			}
		}
		return group;
		
	}		
	public static Group toEntity(JsonGroup jsonGroup) {
		Group group = new Group();
		
		return apply(group, jsonGroup);
	}		
	
	public static List<JsonGroup> toListJsonGroups(List<Group> all) {
		List<JsonGroup> jsonGroups = new ArrayList<JsonGroup>();
		for (Group group : all) {
			jsonGroups.add(toJson(group));
		}
		return jsonGroups;
	}
	//converte de entidade para json --------------------
	private static JsonItem toBasicJson(Item item) {
		JsonItem jsonItem = new JsonItem();
		applyBasicJsonValues(jsonItem, item);
		return jsonItem;
	}
	
	private static Item toBasicEntity(JsonItem jsonItem) {
		Item item = new Item();
		applyBasicEntityValues(item, jsonItem);
		return item;
	}
	
	private static void applyBasicJsonValues(JsonItem jsonItem, Item item) {
		jsonItem.setId(item.getId());
	    jsonItem.setName(item.getName());
	    jsonItem.setItemType(item.getItemType());
	    jsonItem.setIdentifier(item.getIdentifier());
	    jsonItem.setDescription(item.getDescription());
	}	
	private static void applyBasicEntityValues(Item item, JsonItem jsonItem) {
		item.setId(jsonItem.getId());
		item.setName(jsonItem.getName());
		item.setItemType(jsonItem.getItemType());
		item.setIdentifier(jsonItem.getIdentifier());
		item.setDescription(jsonItem.getDescription());
	}	
	
	public static JsonItem toJson(Item item) {
		if(item == null){
			return null;
		}
		
		JsonItem jsonItem = new JsonItem();
		
		applyBasicJsonValues(jsonItem, item);

		List<Permission> listPermissions = item.getPermissions();
		if (listPermissions != null) {
			for (Permission loopPermission : listPermissions) {
				jsonItem.getPermissions().add(toBasicJson(loopPermission));
			}
		}
		return jsonItem;
	}


	public static Item apply(Item item, JsonItem jsonItem) {
	
		if(item ==  null)
			item = new Item();
		
		applyBasicEntityValues(item, jsonItem) ;

		ArrayList<JsonPermission> listPermissions = jsonItem.getPermissions();
		if (listPermissions != null) {
			for (JsonPermission loopJsonPermission : listPermissions) {
				item.addPermissions(toBasicEntity(loopJsonPermission));
			}
		}
					
		return item;
		
	}		
	public static Item toEntity(JsonItem jsonItem) {
		Item item = new Item();
		
		return apply(item, jsonItem);
	}		
	
	public static List<JsonItem> toListJsonItems(List<Item> all) {
		List<JsonItem> jsonItems = new ArrayList<JsonItem>();
		for (Item item : all) {
			jsonItems.add(toJson(item));
		}
		return jsonItems;
	}
}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21