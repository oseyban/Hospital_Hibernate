package com.hospital.repository;


import com.hospital.config.HibernateUtils;
import com.hospital.domain.Doctor;
import com.hospital.domain.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository {
    private Session session;
    public void save(Doctor doctor) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            session.save(doctor);

            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public Doctor find(long id) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.get(Doctor.class, id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public void delete(Doctor doctor) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.delete(doctor);
            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }

    public List<Doctor> findAll(){
        try{
            session = HibernateUtils.getSessionFactory().openSession();
            List<Doctor> doctorList = session.createQuery("FROM Doctor").getResultList();
            return doctorList;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public void addPatientToDoctor(Patient patient, Long id){
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            Doctor doctor = session.get(Doctor.class, id);
            doctor.getPatientList().add(patient);

            System.out.println("*****************");
            System.out.println(doctor.getPatientList());
            System.out.println("*******************");

            tx.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }
}