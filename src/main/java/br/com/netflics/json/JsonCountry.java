package br.com.netflics.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;


/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
public class JsonCountry implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String isoCode;
	private ArrayList<JsonMovie> movies = new ArrayList<JsonMovie>();	
	
	public  JsonCountry() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}
	
	public ArrayList<JsonMovie> getMovies() {
		return movies;
	}
	
	public void setMovies(ArrayList<JsonMovie> movie) {
		this.movies = movie;
	}


}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21