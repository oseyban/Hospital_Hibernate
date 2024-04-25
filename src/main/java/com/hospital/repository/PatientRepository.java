package com.hospital.repository;

import com.hospital.config.HibernateUtils;
import com.hospital.domain.Hospital;
import com.hospital.domain.Patient;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class PatientRepository {
    private Session session;

    public void save(Patient patient){
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(patient);
            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            HibernateUtils.closeSession(session);
        }
    }

    public Patient find(Long id){
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Patient.class, id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public void delete(Patient patient){
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(patient);
            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }


    public List<Patient> getAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            String hqlQuery = "FROM Patient";
            List<Patient> patientList = session.createQuery(hqlQuery, Patient.class).getResultList();
            return patientList;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }
}