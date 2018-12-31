//package com.pruthvi;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Random;
//import java.util.Set;
//
//import org.hibernate.Session;
//
//import com.entity.Account;
//import com.entity.Agency;
//import com.entity.Associate;
//import com.service.HibernateUtil;
//
//public class External {
//
//	public static void main(String[] args) {
//
//		Session session=null;
//		try
//		{					
//			session= HibernateUtil.getSessionFactory().openSession();
//			
//			List<Account> list = createAccounts();
//			for(Account x : list)
//			{
//				Agency a = new Agency();
//				Random rand = new Random();
//				a.setClientRef(rand.nextInt(1000));
//				//x.setAgency(a);
//				session.save(x);
//				//a.setAccount(x);
//				session.save(a);
//				
//				Associate as = new Associate();
//				as.setAccount(x);
//				as.setAgency(a);
//				
//				Associate as1 = new Associate();
//				as1.setAccount(x);
//				as1.setAgency(a);
//				
//				Set<Associate> associates = new HashSet<>();
//				associates.add(as);
//				associates.add(as1);
//				//a.setAssociate(associates );
//				
//				System.out.println(a);
//				Integer a1= (Integer)session.save(a);				
//				session.save(as);
//				
//				Agency a2 =  (Agency) session.get(Agency.class, a1);
//				//System.out.println(a2.getAssociate().size());
//			}				
//		} 
//		catch (Exception e) {
//	         if (session != null) {
//	            System.out.println("Transaction is being rolled back.");	          
//	         }
//	         e.printStackTrace();
//	      } finally {
//	         if (session != null) {
//	            session.close();
//	         }
//	      }
//	      HibernateUtil.shutdown();
//	}
//	
//	public static List<Account> createAccounts()
//	{
//		List<Account> list = new ArrayList<Account>();
//		Account a = new Account();
//		//a.setId(1);
//		a.setStatus(true);
//		a.setUsername("A");
//		a.setPassword("passwordA");
//		
//		Account a1 = new Account();
//		//a1.setId(2);
//		a1.setStatus(false);
//		a1.setUsername("B");
//		a1.setPassword("passwordB");
//		
//		list.add(a); list.add(a1); 
//		//list.add(a2);
//		return list;		
//	}
//
//}
