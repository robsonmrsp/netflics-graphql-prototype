package br.com.netflics.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;


/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
public class JsonGenre implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String genreName;
	
	public  JsonGenre() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	

}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21