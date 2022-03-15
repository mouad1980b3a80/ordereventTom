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
import java.util.function.Function;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;

/**
 *
 * @author hantsy
 */
@Entity
public class TestLsValMAP implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SEQUENCE_NAME = "TESTLSVALMAP_seq";

    public static Comparator<TestLsValMAP> COMPARATOR = Comparator
            .comparing(TestLsValMAP::getMapq)
            .thenComparing(TestLsValMAP::getValueOrig);

    public static Function<TestLsValMAP, String> TO_STRING = t
            -> "Post["
            + "\n title:" + t.getMapq()
            + "\n content:" + t.getValueOrig()
            + "\n status:" + t.getValueMap1()
            + "\n createdAt:" + t.getCreatedDate()
            + "\n lastModifiedAt:" + t.getLastModifiedDate()
            + "]";

    public TestLsValMAP() {
    }

    public static TestLsValMAP of(String mapq, String valueOrig) {
        final TestLsValMAP task = new TestLsValMAP();
        task.setMapq(mapq);
        task.setValueOrig(valueOrig);

        return task;
    }
    
    @Id
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
   // @GeneratedValue(strategy = GenerationType.AUTO) old
    @Column(name = "nMapId")
    private Long mapid;

    @Column(name = "CMAPQ")
    private String mapq;

    @Column(name = "CVALUEORIG")
    private String valueOrig;

    @Column(name = "CVALUEMAP1")
    private String valueMap1;

    @Column(name = "CVALUEMAP2")
    private String valueMap2;

    @Column(name = "CVALUEMAP3")
    private String valueMap3;

    @Column(name = "derfassung")
    private LocalDateTime createdDate;

    @Column(name = "daenderung")
    private LocalDateTime lastModifiedDate;



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
        hash = 67 * hash + Objects.hashCode(this.mapid);
        hash = 67 * hash + Objects.hashCode(this.mapq);
        hash = 67 * hash + Objects.hashCode(this.valueOrig);
        hash = 67 * hash + Objects.hashCode(this.valueMap1);
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
        final TestLsValMAP other = (TestLsValMAP) obj;
        if (!Objects.equals(this.mapq, other.mapq)) {
            return false;
        }
        if (!Objects.equals(this.valueOrig, other.valueOrig)) {
            return false;
        }
        if (!Objects.equals(this.valueMap1, other.valueMap1)) {
            return false;
        }
        if (this.valueMap2 != other.valueMap2) {
            return false;
        }
        if (!Objects.equals(this.createdDate, other.createdDate)) {
            return false;
        }
        return Objects.equals(this.lastModifiedDate, other.lastModifiedDate);
    }

    @PrePersist
    public void prePersist() {
        this.setCreatedDate(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.setLastModifiedDate(LocalDateTime.now());
    }

    public Long getMapid() {
        return mapid;
    }

    public void setMapid(Long mapid) {
        this.mapid = mapid;
    }

    public String getMapq() {
        return mapq;
    }

    public void setMapq(String mapq) {
        this.mapq = mapq;
    }

    public String getValueOrig() {
        return valueOrig;
    }

    public void setValueOrig(String valueOrig) {
        this.valueOrig = valueOrig;
    }

    public String getValueMap1() {
        return valueMap1;
    }

    public void setValueMap1(String valueMap1) {
        this.valueMap1 = valueMap1;
    }

    public String getValueMap2() {
        return valueMap2;
    }

    public void setValueMap2(String valueMap2) {
        this.valueMap2 = valueMap2;
    }

    public String getValueMap3() {
        return valueMap3;
    }

    public void setValueMap3(String valueMap3) {
        this.valueMap3 = valueMap3;
    }
}
