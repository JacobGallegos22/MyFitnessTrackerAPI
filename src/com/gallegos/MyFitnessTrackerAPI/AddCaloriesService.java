package com.gallegos.MyFitnessTrackerAPI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddCaloriesService {
  SessionFactory factory = HibernateUtils.getSessionFactory();
  Session session = factory.openSession();

  public AddCaloriesService(Calories calories) {
    if(!(session.getTransaction().isActive())){
      session.getTransaction().begin();
    }
    if (calories == null) {
      return;
    }

    session.save(calories);
    session.getTransaction().commit();






  }
}
