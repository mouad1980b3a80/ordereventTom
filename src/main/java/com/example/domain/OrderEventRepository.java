package com.example.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.Column;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.constraints.NotNull;

public class OrderEventRepository implements Serializable {
   private static final long serialVersionUID = 1L;


   @PersistenceContext(unitName="OraclePU")
   EntityManager em;

   public List<OrderEventHistory> getOrderEvents() {
      List<OrderEventHistory> records = new ArrayList<>();
      List results;
      try {
         //records = new ArrayList<>();
         // TODO use jdbc resource instead
         Query nativeQuery = em.createNativeQuery(
             "select NAUFID, NAUFEDIID, CMANID, CEVENTTYPE, CACTIONCLASS, CORDERTYPE, CACTION" +
                 ", CINFO1, CINFO2, CINFO3, CINFO4, CINFO5, CEDIREF" +
                                                      " from lsOrderEventHistory").setMaxResults(100);
         results = nativeQuery.getResultList();
         for (Object result : results) {
            OrderEventHistory orderEventHistory = new OrderEventHistory();
            Object[] resultSet = (Object[])result;
            int i = 0;
            orderEventHistory.setAufId(((BigDecimal)resultSet[i]).longValue());
            i++;
            orderEventHistory.setAufEdiId(((BigDecimal)resultSet[i]).longValue());
            i++;
            orderEventHistory.setManId((String)resultSet[i]);
            i++;
            orderEventHistory.setEventType((String)resultSet[i]);
            i++;
            orderEventHistory.setActionClass((String)resultSet[i]);
            i++;
            orderEventHistory.setOrderType((String)resultSet[i]);
            i++;
            orderEventHistory.setAction((String)resultSet[i]);
            i++;
            orderEventHistory.setInfo1((String)resultSet[i]);
            i++;
            orderEventHistory.setInfo2((String)resultSet[i]);
            i++;
            orderEventHistory.setInfo3((String)resultSet[i]);
            i++;
            orderEventHistory.setInfo4((String)resultSet[i]);
            i++;
            orderEventHistory.setInfo5((String)resultSet[i]);
            i++;
            orderEventHistory.setEdiRef((String)resultSet[i]);
            i++;

            records.add(orderEventHistory);
         }

         //createQuery("select e from OrderEventHistory e ", OrderEventHistory.class)
           //  .setMaxResults(100).getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return records;
   }
}