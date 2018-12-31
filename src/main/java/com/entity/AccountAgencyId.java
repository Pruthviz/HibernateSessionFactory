package com.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AccountAgencyId  implements Serializable
{
	@ManyToOne(cascade = CascadeType.ALL)
	private Account account;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Agency agency;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}	
}
