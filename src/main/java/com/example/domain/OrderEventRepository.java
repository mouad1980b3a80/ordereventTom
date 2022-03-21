package com.example.domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class OrderEventRepository implements Serializable {
   private static final long serialVersionUID = 1L;


   @PersistenceContext(unitName="OraclePU")
   EntityManager em;

   public List<OrderEventHistory> getAuthors() {
      List<OrderEventHistory> records = null;
      
      try {
         records = em.createQuery("select e from OrderEventHistory e ", OrderEventHistory.class)
             .setMaxResults(100).getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return records;
   }
}