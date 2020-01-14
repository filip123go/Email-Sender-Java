package com.stavros.mailscheduler.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@ApiModel
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@ApiModelProperty(value = "id", required = true)
	private long id;

	@Column(name = "username")
	@ApiModelProperty(value = "username", required = true)
	private String username;

	@Column(name = "password")
	@ApiModelProperty(value = "password", required = true)
	private String password;

	@Column(name = "blocked")
	@ApiModelProperty(value = "blocked", required = true)
	private int active;

	@Column(name = "roles")
	@ApiModelProperty(value = "roles", required = true)
	private String roles;

	@Column(name = "permissions")
	@ApiModelProperty(value = "permissions", required = true)
	private String permissions;

	@Column(name = "first_name")
	@ApiModelProperty(value = "first name", required = true)
	private String firstName;

	@Column(name = "last_name")
	@ApiModelProperty(value = "last name", required = true)
	private String lastName;

	@Column(name = "email")
	@ApiModelProperty(value = "email", required = true)
	private String email;

	public User(String username, String password, int active, String roles, String permissions, String firstName, String lastName, String email) {
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
		this.permissions = permissions;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public List<String> getRoleList(){
		if(this.roles.length() > 0){
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<>();
	}

	public List<String> getPermissionList(){
		if(this.permissions.length() > 0){
			return Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<>();
	}
}
