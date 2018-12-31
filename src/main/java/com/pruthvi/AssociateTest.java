package com.pruthvi;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Query;

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
			
			tx = saveAssociate(session,tx,3,1);
			
			tx = removeAssociate(session,tx,1,3);
		} 
		catch (Exception e) 
		{
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

	private static Transaction removeAssociate(Session session, Transaction tx, int Agency_ID,int Account_ID) 
	{			
		tx = session.beginTransaction();
		
		Query query = session.createQuery("delete Associate where Agency_ID = :Agency_ID and Account_ID = :Account_ID");
		query.setParameter("Agency_ID", Agency_ID);
		query.setParameter("Account_ID", Account_ID);
		 
		int result = query.executeUpdate();
		 
		if (result > 0) 
		{
		    System.out.println("Associate was removed\n");
		}
		else
		{
			System.out.println("Associate was not removed\n");
		}
		tx.commit();
		return tx;
	}

	private static Transaction saveAssociate(Session session,Transaction tx,Integer account_id,Integer agency_id) 
	{		
		tx = session.beginTransaction();
		Account ac =  (Account) session.get(Account.class, account_id);
		Agency ag =  (Agency) session.get(Agency.class, agency_id);
			if(ac.isStatus())
			{
				Associate as = new Associate();
				as.setAccount(ac);
				as.setAgency(ag);
				
				session.save(as);
				Set<Associate> associates =new HashSet<Associate>();
				associates.add(as);
				
				ac.setAssociates(associates);
				ag.setAssociates(associates);
				
				session.save(ac);
				session.save(ag);
			}
		tx.commit();
		return tx;
	}

	
		

}
