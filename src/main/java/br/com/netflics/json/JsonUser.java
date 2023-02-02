package br.com.netflics.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalDateTime;


/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
public class JsonUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String username;
	private String email;
	private String password;
	private Boolean enable;
	private String image;
	private ArrayList<JsonRole> roles = new ArrayList<JsonRole>();	
	
	public  JsonUser() {
		
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
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public ArrayList<JsonRole> getRoles() {
		return roles;
	}
	
	public void setRoles(ArrayList<JsonRole> role) {
		this.roles = role;
	}


}
//generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21