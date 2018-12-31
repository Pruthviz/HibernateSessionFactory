package com.pruthvi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Account;
import com.entity.Agency;
import com.entity.Associate;
import com.service.HibernateUtil;

public class AssociateTest {

	public static void main(String[] args) {

		Transaction tx =null;
		Session session=null;
		try
		{			
			
			session= HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Account ac =  (Account) session.get(Account.class, 3);
			Agency ag =  (Agency) session.get(Agency.class, 2);
				if(ac.isStatus())
				{
					Associate as = new Associate();
					as.setAccount(ac);
					as.setAgency(ag);
					as.setIsActive('Y');
					as.setIsAdmin('Y');
					
					session.save(as);
					Set<Associate> associates =new HashSet<Associate>();
					associates.add(as);
					
					ac.setAssociates(associates);
					ag.setAssociates(associates);
					
					session.save(ac);
					session.save(ag);
				}
			
			tx.commit();
						
		} 
		catch (Exception e) {
	         if (tx != null) {
	            System.out.println("Transaction is being rolled back.");	          
	         }
	         e.printStackTrace();
	      } finally {
	         if (tx != null) {
	            session.close();
	         }
	      }
	      HibernateUtil.shutdown();
	}

	
		

}
