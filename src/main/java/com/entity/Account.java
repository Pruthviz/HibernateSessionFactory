package com.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Account")
public class Account 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Account_ID")
   private Integer id;

   @Column(unique = true)
   private String username;

   private String password;
   
   private boolean status;
   
   @OneToOne(mappedBy="account", cascade=CascadeType.ALL)
   private Agency agency;
   
   @OneToMany(mappedBy = "primaryKey.account",cascade = CascadeType.ALL)
   private Set<Associate> associates;   
   
   public Account() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<Associate> getAssociates() {
		return associates;
	}

	public void setAssociates(Set<Associate> associates) {
		this.associates = associates;
	}			
}
