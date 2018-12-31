package com.service;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.entity.Account;
import com.entity.Agency;
import com.entity.Associate;
import com.entity.User;
import com.entity.UserDetail;

public class HibernateUtil {
	  private static StandardServiceRegistry standardServiceRegistry;
	  private static SessionFactory sessionFactory;
	 
	  static{
		    if (sessionFactory == null) {
		      try {
		        // Create StandardServiceRegistry
		        standardServiceRegistry = new StandardServiceRegistryBuilder()
		            .configure()
		            .build();
		        // Create MetadataSources
		        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry).addAnnotatedClass(User.class)
		                  .addAnnotatedClass(UserDetail.class)
		                  .addAnnotatedClass(Account.class)
		                  .addAnnotatedClass(Associate.class)
		                  .addAnnotatedClass(Agency.class);
;
		        // Create Metadata
		        Metadata metadata = metadataSources.getMetadataBuilder().build();
		        // Create SessionFactory
		        sessionFactory = metadata.getSessionFactoryBuilder().build();
		      } catch (Exception e) {
		        e.printStackTrace();
		        if (standardServiceRegistry != null) {
		          StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
		        }
		      }
		    }
	  }
	  //Utility method to return SessionFactory
	  public static SessionFactory getSessionFactory() {
		  return sessionFactory;
	  }
	  
	  public static void shutdown() {
	      if (standardServiceRegistry != null) {
	         StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
	      }
	   }
	}
