package com.evry.form;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FormHandlerDao {

	public static TestForm testform;
	
	public boolean submitForm(TestForm tf)
	{
		StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(sr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		
		
		
		session.save(tf);
		t.commit();
		System.out.println("Done with trnasaction");
		factory.close();
//		session.close();
		return true;
	}
	
	public TestForm viewFormData(String name)
	{
		System.out.println(name);
		
		StandardServiceRegistry sr= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(sr).getMetadataBuilder().build();
		
		SessionFactory factory =meta.getSessionFactoryBuilder().build();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		
		
		
		testform=session.get(TestForm.class,name);
		t.commit();
		System.out.println("Done with trnasaction");
		factory.close();
//		session.close();
		
		return testform;
	}
}
