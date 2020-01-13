package com.stavros.mailscheduler.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel
@Table(name = "Users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@ApiModelProperty(value = "id", required = true)
	private long id;

	@Column(name = "first_name")
	@ApiModelProperty(value = "first name", required = true)
	private String firstName;

	@Column(name = "last_name")
	@ApiModelProperty(value = "last name", required = true)
	private String lastName;

	@Column(name = "username")
	@ApiModelProperty(value = "username", required = true)
	private String username;

	@Column(name = "email")
	@ApiModelProperty(value = "email", required = true)
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
}
