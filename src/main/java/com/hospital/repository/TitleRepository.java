package com.hospital.repository;

import com.hospital.config.HibernateUtils;
import com.hospital.domain.Title;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TitleRepository {

    private Session session;

    public void save(Title title) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(title);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void update(Title title) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(title);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
    }


    public Title findTitleByName(String titleName) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            String hqlQuery = "FROM Title t WHERE t.titleName = :titleName";
            return session.createQuery(hqlQuery, Title.class)  //BU SATIR ONEMLI
                    .setParameter("titleName", titleName)
                    .uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

}