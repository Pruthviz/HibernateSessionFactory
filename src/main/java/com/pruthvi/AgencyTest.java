package com.pruthvi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;

import com.entity.Account;
import com.entity.Agency;
import com.service.HibernateUtil;

public class AgencyTest {

	public static void main(String[] args) {

		Session session=null;
		try
		{					
			session= HibernateUtil.getSessionFactory().openSession();
			
			List<Account> list = loadAllData(Account.class,session);
			
			int count=0;
			for(Account x : list)
			{
				if(x.isStatus())
				{
					Agency a = new Agency();
					Random rand = new Random();
					a.setClientRef(rand.nextInt(1000));	
					a.setAccount(x);
					session.save(a);
					count++;
				}				
			}
			
			System.out.println(list.size()+" count "+count);				
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

	private static <T> List<T> loadAllData(Class<T> type, Session session) {
	    CriteriaBuilder builder = session.getCriteriaBuilder();
	    CriteriaQuery<T> criteria = builder.createQuery(type);
	    criteria.from(type);
	    List<T> data = session.createQuery(criteria).getResultList();
	    return data;
	  }

}
