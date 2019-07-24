package com.gallegos.MyFitnessTrackerAPI;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "weight")
public class Weight {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private int id;

  @Column(name = "weight")
  private String weight;

  @Column(name = "weigh_date")
  private Date weighDate;

  @ManyToOne
  @Column(name = "user_id")
  private User user;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public Date getWeighDate() {
    return weighDate;
  }

  public void setWeighDate(Date weighDate) {
    this.weighDate = weighDate;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }



}
