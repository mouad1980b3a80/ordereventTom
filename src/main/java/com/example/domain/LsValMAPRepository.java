package com.example.domain;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 *
 * @author hantsy
 */
@Stateless
public class LsValMAPRepository {

  // @PersistenceContext(unitName="OraclePU")
   private EntityManager em;



    public TestLsValMAP findById(Long id) {

        TestLsValMAP task = getEm().find(TestLsValMAP.class, id);
        if (task == null) {
            throw new ValMapNotFoundException(id);
        }

        return task;
    }
/*
    public List<LsValMAP> findByStatus(String mapq) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();

        CriteriaQuery<Task> q = cb.createQuery(LsValMAP.class);
        Root<LsValMAP> c = q.from(LsValMAP.class);
        q.where(cb.equal(c.get(LsValMAP_.status), mapq));

        TypedQuery<Task> query = em.createQuery(q);

        return query.getResultList();
    }
*/
    public List<TestLsValMAP> findAll() {
        /*String query = "SELECT * FROM LsValMAP"; //here goes the query text
        List<LsValMAP> valMAPS = new ArrayList<>();
        System.out.println("connection nmpid= " + dataSource);
        try(Connection connection= dataSource.getConnection();

            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery(query)) {
            System.out.println("resultSet nmpid= " + resultSet.getMetaData());
            while (resultSet.next()) {
                LsValMAP valMap = new LsValMAP();
                System.out.println("LsValmap nmpid= " + resultSet.getLong("nmapid"));
                valMap.setMapid(resultSet.getLong("nmapid"));
                valMap.setMapq(resultSet.getString("cmapq"));
                valMap.setValueOrig(resultSet.getString("cvalueorig"));
            }
            //some actions with resultSet

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        CriteriaBuilder cb = this.getEm().getCriteriaBuilder();

        CriteriaQuery<TestLsValMAP> q = cb.createQuery(TestLsValMAP.class);
        Root<TestLsValMAP> c = q.from(TestLsValMAP.class);
        //q.where(cb.equal(c.get(LsValMAP_.status), mapq));

        TypedQuery<TestLsValMAP> query = getEm().createQuery(q);

        return query.getResultList();
        //return valMAPS;
    }


    public TestLsValMAP save(TestLsValMAP LsValMAP) {
        getEm().persist(LsValMAP);

        return LsValMAP;
    }

    public TestLsValMAP update(TestLsValMAP task) {
        return getEm().merge(task);
    }

    public void delete(TestLsValMAP task) {
        task = getEm().merge(task);
        getEm().remove(task);
    }

    public void deleteById(Long id) {
        TestLsValMAP task = getEm().find(TestLsValMAP.class, id);
        if (task == null) {
            throw new ValMapNotFoundException(id);
        }

        getEm().remove(task);
    }

    public EntityManager getEm() {
        if (em == null) {
            try {

                InitialContext ctx = new InitialContext();
           // UserTransaction tran = (UserTransaction) ctx.lookup("java:comp/UserTransaction");
           // tran.begin();
                //  java:jboss/datasources/lsDS
            this.em = (EntityManager) ctx.lookup("java:comp/myDB/em");
           // Task thing = new Thing();
           // em.persist(thing);
           // tran.commit();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
