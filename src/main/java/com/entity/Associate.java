package com.entity;


import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Associate")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.account",
        joinColumns = @JoinColumn(name = "Account_ID")),
    @AssociationOverride(name = "primaryKey.agency",
        joinColumns = @JoinColumn(name = "Agency_ID")) })
public class Associate implements Serializable
{
	@EmbeddedId
	private AccountAgencyId primaryKey = new AccountAgencyId();
	
	@Column(name = "IS_ADMIN")
	private char isAdmin = 'N';

	@Column(name = "IS_ACTIVE")
	private char isActive = 'Y';
	
	public Associate() 
	{
		
	}
	
	public AccountAgencyId getPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(AccountAgencyId primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Transient
    public Account getAccount() {
        return getPrimaryKey().getAccount();
    }
 
    public void setAccount(Account account) {
        getPrimaryKey().setAccount(account);
    }
 
    @Transient
    public Agency getAgency() {
        return getPrimaryKey().getAgency();
    }
 
    public void setAgency(Agency agency) {
        getPrimaryKey().setAgency(agency);
    }

	public char getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(char isAdmin) {
		this.isAdmin = isAdmin;
	}

	public char getIsActive() {
		return isActive;
	}

	public void setIsActive(char isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Associate [primaryKey=" + primaryKey + ", isAdmin=" + isAdmin + ", isActive=" + isActive + "]";
	}		
   
}
