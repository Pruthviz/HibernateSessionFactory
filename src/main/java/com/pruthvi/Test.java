package com.pruthvi;

import java.time.LocalDate;
import java.time.Month;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.User;
import com.entity.UserDetail;
import com.service.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Transaction transaction = null;
		Session session=null;
		try
		{					
			session= HibernateUtil.getSessionFactory().openSession();
			//transaction = session.beginTransaction();
		   // transaction.begin();
		         
		    User user = new User();
		    user.setId(1);
		    user.setUsername("Pruthvi");
		    user.setPassword("password123");
		    UserDetail userdetail = new UserDetail();
		    userdetail.setEmail("prudodo@gmail.com");
		    userdetail.setFirstName("Pruthviraj");
		    userdetail.setLastName("SP");
			userdetail.setDob(LocalDate.of(1992, Month.AUGUST, 6) );
		    user.setUserDetail(userdetail);
		    
			session.save(user);
		   // transaction.commit();	         
		         
		         
		} 
		catch (Exception e) {
	         if (session != null) {
	            System.out.println("Transaction is being rolled back.");
	           // transaction.rollback();
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
