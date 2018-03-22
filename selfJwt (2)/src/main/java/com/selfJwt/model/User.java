package com.selfJwt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  long id;

	@Column(unique = true)
	@Email(message="provide valid email address")
	@NotEmpty(message = "email is mandatory")
	private  String email;

	@NotNull(message = "age is mandatory")
	private  int age;

	@NotEmpty(message = "name is mandatory")
	private  String name;

	@ManyToMany()
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id"),
			@JoinColumn(name = "user_email", referencedColumnName = "email") }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", referencedColumnName = "id"),
					@JoinColumn(name = "role_name", referencedColumnName = "rolesName") })
	private  Set<Roles> roles;

	@NotEmpty(message = "password is mandatory")
	private String password;

	@JsonIgnore
	@JsonProperty(value = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
