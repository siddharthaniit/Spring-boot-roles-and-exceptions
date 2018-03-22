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

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  long id;

	@Column(unique = true)
	@NotEmpty(message = "RoleName is mandatory")
	private String rolesName;

	@ManyToMany()
	@JoinTable(name = "roles_privileges", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id"),
			@JoinColumn(name = "roles_name", referencedColumnName = "rolesName") }, inverseJoinColumns = {
					@JoinColumn(name = "privilege_id", referencedColumnName = "id"),
					@JoinColumn(name = "privilege_name", referencedColumnName = "name") })
	private Set<Privilege> privileges;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRolesName() {
		return rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
