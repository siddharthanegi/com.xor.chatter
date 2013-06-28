package com.xor.chatter.form;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;



@Entity(name="Users")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="uid")
	private Integer uid;
	
	@Column(name="firstname")
	private String firstName;
	

	@Column(name="lastname")
	private String lastName;

	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="username")
	private String username;

	@Column(name="password", unique=true)
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Friend_Map",
				joinColumns={ @JoinColumn(name="uid1")},
				inverseJoinColumns={ @JoinColumn(name="uid2")})
	private Set<User> friends;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Friend_Map",
				joinColumns={ @JoinColumn(name="uid2")},
				inverseJoinColumns={ @JoinColumn(name="uid1")})
	private Set<User> friendOf;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<User> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(Set<User> friendOf) {
		this.friendOf = friendOf;
	}
	

}
