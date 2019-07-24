package com.gallegos.MyFitnessTrackerAPI;

import com.gallegos.MyFitnessTrackerAPI.HibernateUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "com.gallegos.MyFitnessTrackerAPI.Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
  SessionFactory factory = HibernateUtils.getSessionFactory();
  Session session = factory.openSession();
  Gson gson = new Gson();

  protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    String email = request.getParameter("email");
    response.setContentType("application/json");

    if(!(session.getTransaction().isActive())){
      session.getTransaction().begin();
    }


    if (email == null) {
      try{
        String hql = "from user " ;
        Query query = session.createNativeQuery(hql);
        List<User> users = query.list();
        JsonArray jsonArray = (JsonArray) gson.toJsonTree(users, new TypeToken<List<User>>() {}.getType());
        String output = jsonArray.toString();
        out.print(output);
        out.flush();

      } catch (Exception e) {
        e.printStackTrace();

      }

    } else {
      try{
        String hql = "SELECT * FROM user WHERE email = '" + email + "'" ;
        Query query = session.createNativeQuery(hql);
        ((NativeQuery) query).addEntity(User.class);
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        String jsonOutput = gson.toJson(user);
        out.print(jsonOutput);
        out.flush();

      } catch (Exception e) {
        e.printStackTrace();
        response.setStatus(404);
      }

    }







  }
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    if(!(session.getTransaction().isActive())){
      session.getTransaction().begin();
    }

    try {
      response.setContentType("application/json");
      StringBuilder buffer = new StringBuilder();
      BufferedReader reader = request.getReader();
      String line;
      while ((line = reader.readLine()) != null) {
        buffer.append(line);
      }
      String data = buffer.toString();
      User user = gson.fromJson(data, User.class);
      session.save(user);
      session.getTransaction().commit();

    } catch (Exception e) {
      response.setStatus(404);
    }





  }


}
