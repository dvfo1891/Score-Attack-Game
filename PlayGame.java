package com.game.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PlayGame {
	public static void main(String [] args){
		UserData data2 = new UserData("aabb",70);
		
		addData(data2);
	}
	
	
	public static void addData(UserData data){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(data);
		UserData data1 = (UserData)session.get(UserData.class, "a");
		System.out.println(data1.getScore());
		session.getTransaction().commit();
	}
}
