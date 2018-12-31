package com.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@Column(name = "USR_ID")
   private long id;

  // @Column(name = "USERNAME", nullable = false, unique = true)
   private String username;

   //@Column(name = "PASSWORD")
   private String password;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="USER_DETAILS_ID")
   private UserDetail userDetail;

	public User() {
		super();
	}
	
	public User(long id, String username, String password, UserDetail userDetail) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.userDetail = userDetail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userDetail=" + userDetail
				+ "]";
	}
}
