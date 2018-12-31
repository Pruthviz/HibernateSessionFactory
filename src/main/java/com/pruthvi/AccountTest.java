package com.pruthvi;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.entity.Account;
import com.entity.Associate;
import com.service.HibernateUtil;

public class AccountTest {

	public static void main(String[] args) {

		Session session=null;
		try
		{					
			session= HibernateUtil.getSessionFactory().openSession();
			
			List<Account> list = createAccounts();
			for(Account x : list)
			{
				session.save(x);
			}				
		} 
		catch (Exception e) {
	         if (session != null) {
	            System.out.println("Transaction is being rolled back.");	          
	         }
	         e.printStackTrace();
	      } finally {
	         if (session != null) {
	            session.close();
	         }
	      }
	      HibernateUtil.shutdown();
	}
	
	public static List<Account> createAccounts()
	{
		List<Account> list = new ArrayList<Account>();
		Account a = new Account();
		
		a.setStatus(true);
		a.setUsername("A");
		a.setPassword("passwordA");
		
		Account a1 = new Account();
		
		a1.setStatus(false);
		a1.setUsername("B");
		a1.setPassword("passwordB");
		
		Account a2 = new Account();
		
		a2.setStatus(true);
		a2.setUsername("C");
		a2.setPassword("passwordA");
		
		Account a3 = new Account();
		
		a3.setStatus(false);
		a3.setUsername("D");
		a3.setPassword("passwordB");
		
		Account a21 = new Account();
		
		a21.setStatus(true);
		a21.setUsername("E");
		a21.setPassword("passwordA");
		
		Account a31 = new Account();
		
		a31.setStatus(true);
		a31.setUsername("F");
		a31.setPassword("passwordB");		
		
		list.add(a); list.add(a1);
		list.add(a2); list.add(a3); 
		list.add(a21); list.add(a31); 
		return list;		
	}

}
