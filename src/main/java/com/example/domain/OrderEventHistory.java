/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 *
 */
//@Entity
//@Table(name="lsordereventhistory")
public class OrderEventHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SEQUENCE_NAME = "LSORDEREVENTHISTORY_S0";

    public static Comparator<OrderEventHistory> COMPARATOR = Comparator
            .comparing(OrderEventHistory::getEdiRef)
            .thenComparing(OrderEventHistory::getAufId);

   /* public static Function<OrderEventHistory, String> TO_STRING = t
            -> "Post["
            + "\n title:" + t.getMapq()
            + "\n content:" + t.getValueOrig()
            + "\n status:" + t.getValueMap1()
            + "\n createdAt:" + t.getCreatedDate()
            + "\n lastModifiedAt:" + t.getLastModifiedDate()
            + "]";
            */


    public OrderEventHistory() {
    }

  /*  public static OrderEventHistory of(String mapq, String valueOrig) {
        final OrderEventHistory task = new OrderEventHistory();
        task.setMapq(mapq);
        task.setValueOrig(valueOrig);

        return task;
    }/

        /*    DERFASSUNG	1			N	DATE
    DAENDERUNG	2			N	DATE
    CUSERNAME	3			N	VARCHAR2 (30 Char)
    CMANID	4		1, 1	N	VARCHAR2 (10 Char)
    NAUFEDIID	5	1	1	N	NUMBER (10)
    NAUFID	6		1	Y	NUMBER (10)
    CEVENTTYPE	7		2	N	VARCHAR2 (30 Char)
    CACTIONCLASS	8			N	VARCHAR2 (200 Char)
    CORDERTYPE	9		1	N	VARCHAR2 (30 Char)
    CACTION	10			N	VARCHAR2 (30 Char)
    CINFO1	11		3	Y	VARCHAR2 (200 Char)
    CINFO2	12		4	Y	VARCHAR2 (200 Char)
    CINFO3	13		5	Y	VARCHAR2 (200 Char)
    CINFO4	14		6	Y	VARCHAR2 (200 Char)
    CINFO5	15			Y	VARCHAR2 (1024 Char)
    CEDIREF	16		2	Y	VARCHAR2 (100 Char)*/
    
  //  @Id
   // @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)

   // @Column(name = "NAUFID")
    private Long aufId;

   // @Column(name = "NAUFEDIID")
    private Long aufEdiId;

   // @Column(name = "CMANID")
   // @NotNull
    private String manId;

    // @Column(name = "CEVENTTYPE")
    // @NotNull
    private String eventType;

    // @Column(name = "CACTIONCLASS")
    // @NotNull
    private String actionClass;

    // @Column(name = "CORDERTYPE")
    private String orderType;

    /// @Column(name = "CACTION")
    private String action;

    // @Column(name = "CINFO1")
    private String info1;

    // @Column(name = "CINFO2")
    private String info2;

    // @Column(name = "CINFO3")
    private String info3;

    // @Column(name = "CINFO4")
    private String info4;

    // @Column(name = "CINFO5")
    private String info5;

    // @Column(name = "CEDIREF")
    private String ediRef;

    // @Column(name = "derfassung")
    private LocalDateTime createdDate;
//TODO: check localDateTime again
    // @Column(name = "daenderung")
    private LocalDateTime lastModifiedDate;

    // @Column(name = "CUSERNAME")
    // @NotNull
    private String username;


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.getAufId());
        hash = 67 * hash + Objects.hashCode(this.getAufEdiId());
        hash = 67 * hash + Objects.hashCode(this.getManId());
        hash = 67 * hash + Objects.hashCode(this.getEventType());
        hash = 67 * hash + Objects.hashCode(this.createdDate);
        hash = 67 * hash + Objects.hashCode(this.lastModifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderEventHistory other = (OrderEventHistory) obj;
        if (!Objects.equals(this.getAufEdiId(), other.getAufEdiId())) {
            return false;
        }
        // TODO: copy from ls
        if (!Objects.equals(this.getAufId(), other.getAufId())) {
            return false;
        }
        if (!Objects.equals(this.getEventType(), other.getEventType())) {
            return false;
        }
        if (this.getOrderType() != other.getOrderType()) {
            return false;
        }
        if (!Objects.equals(this.createdDate, other.createdDate)) {
            return false;
        }
        if (!Objects.equals(this.lastModifiedDate, other.lastModifiedDate)) {
            return false;
        }
        return true;
    }

    @PrePersist
    public void prePersist() {
        this.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.setLastModifiedDate(LocalDateTime.now());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAufId() {
        return aufId;
    }

    public void setAufId(Long aufId) {
        this.aufId = aufId;
    }

    public Long getAufEdiId() {
        return aufEdiId;
    }

    public void setAufEdiId(Long aufEdiId) {
        this.aufEdiId = aufEdiId;
    }

    public String getManId() {
        return manId;
    }

    public void setManId(String manId) {
        this.manId = manId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getActionClass() {
        return actionClass;
    }

    public void setActionClass(String actionClass) {
        this.actionClass = actionClass;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3;
    }

    public String getInfo4() {
        return info4;
    }

    public void setInfo4(String info4) {
        this.info4 = info4;
    }

    public String getInfo5() {
        return info5;
    }

    public void setInfo5(String info5) {
        this.info5 = info5;
    }

    public String getEdiRef() {
        return ediRef;
    }

    public void setEdiRef(String ediRef) {
        this.ediRef = ediRef;
    }
}
