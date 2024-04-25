package com.hospital.config;


import com.hospital.domain.Doctor;
import com.hospital.domain.MedicalCase;
import com.hospital.domain.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Doctor.class)
                    .addAnnotatedClass(MedicalCase.class)
                    .addAnnotatedClass(Patient.class);

            sessionFactory = configuration.buildSessionFactory();


        } catch (Exception e) {
            System.err.println("Initialization of session factory is FAILED!!!");
        }
    }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }


        public static void shutDown(){
            getSessionFactory().close();
        }

    public static void closeSession(Session session){
        if (session!=null && session.isOpen()){
            session.close();
        }
    }
    }




