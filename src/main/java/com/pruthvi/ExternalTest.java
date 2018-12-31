package com.pruthvi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.Session;

import com.entity.Account;
import com.entity.Agency;
import com.entity.Associate;
import com.service.HibernateUtil;

public class ExternalTest {

	public static void main(String[] args) {

		Session session=null;
		try
		{					
			session= HibernateUtil.getSessionFactory().openSession();
												
			Agency a2 =  (Agency) session.get(Agency.class, 3);
			//System.out.println(a2.getAssociate().size());
							
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

}
