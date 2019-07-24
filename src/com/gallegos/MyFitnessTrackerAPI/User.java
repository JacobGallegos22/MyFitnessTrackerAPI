package com.gallegos.MyFitnessTrackerAPI;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="id")
  private int id;

  @Column(name = "firstName")
  private String firstName;

  @Column(name = "lastName")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

}
