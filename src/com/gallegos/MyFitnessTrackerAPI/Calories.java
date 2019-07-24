package com.gallegos.MyFitnessTrackerAPI;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "calories")
public class Calories {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private int id;

  @Column(name = "calories_total")
  private Long caloriesTotal;

  @Column(name = "calories_date")
  private Date caloriesDate;

  @ManyToOne
  @Column(name = "user_id")
  private User user;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Long getCalories() {
    return caloriesTotal;
  }

  public void setCalories(Long calories) {
    this.caloriesTotal = calories;
  }

  public Date getCaloriesDate() {
    return caloriesDate;
  }

  public void setCaloriesDate(Date caloriesDate) {
    this.caloriesDate = caloriesDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
