package group.G; 

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@Entity
@Table(name="users")
public class UserModel implements Serializable {

	@Id
	private String id;

	private String pass, city;

	
	// Getters Setters
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	@JsonProperty
	public void setPass(String pass) {
		this.pass = pass;
	}

	// Don't serialzie password
	@JsonIgnore
	public String getPass() {
		return this.pass;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}
	// End Getters Setter

	// Constructor
	public UserModel(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public UserModel(String id, String pass, String city) {
		this(id,pass);
		this.city = city;
	}

	public UserModel(String id) {
		this.id = id;
	}

	// No arg constructor required by hibernate
	public UserModel() { }
	// End Constructors


	@Override
	public String toString() {
		return "User [" + id +  "," + city + "]"; 
	}
}