package com.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Agency" ,uniqueConstraints={@UniqueConstraint(columnNames={"ACCOUNT_ID"})} )
public class Agency 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "Agency_ID")
   private Integer id;
   
   @Column(unique = true)
   private Integer clientRef;
   
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="ACCOUNT_ID")
   private Account account;
   
   @OneToMany(mappedBy = "primaryKey.agency",
           cascade = CascadeType.ALL)
   private Set<Associate> associates; 

   public Agency() {
		super();
	}

   public Integer getId() {
		return id;
	}
	
   public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientRef() {
		return clientRef;
	}

	public void setClientRef(Integer clientRef) {
		this.clientRef = clientRef;
	}

	public Set<Associate> getAssociates() {
		return associates;
	}

	public void setAssociates(Set<Associate> associates) {
		this.associates = associates;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Agency [id=" + id + ", clientRef = " + clientRef + " associates=" + associates
				+ "]";
	}
}
