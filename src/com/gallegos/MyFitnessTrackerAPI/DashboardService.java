package com.gallegos.MyFitnessTrackerAPI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class DashboardService {
  SessionFactory factory = HibernateUtils.getSessionFactory();
  Session session = factory.openSession();
  private String id;
  Date now = new Date();

  public DashboardService(String id) {
    if(!(session.getTransaction().isActive())){
      session.getTransaction().begin();
    }
    this.id = id;
  }

  public Long listDailyCalories () {
    long total = 0L;
    String hql = "SELECT calories FROM calories";
    Query query = session.createNativeQuery(hql);
    List<Calories> calories = query.list();
    for (Calories calories1 : calories ) {
       total =+ calories1.getCalories();
    }
    return total;
  }
  public void listDailyWorkout () {

  }


}
