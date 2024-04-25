package com.hospital.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
    @Id
    private int patientID;

    @Column(nullable = false)
    private String patientName;

    @Column(nullable = false)
    private String patientSurname;


    @ManyToMany(mappedBy = "patients")
    private List<MedicalCase> medicalCases;

    @ManyToMany(mappedBy = "patientList", fetch = FetchType.EAGER)
    private List<Doctor> doctorList;



    public Patient() {
    }

    public Patient(int patientID, String patientName, String patientSurname, String actualCase, boolean isEmergency, List<MedicalCase> medicalCases, List<Doctor> doctorList) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.medicalCases = medicalCases;
        this.doctorList = doctorList;
    }

    public List<MedicalCase> getMedicalCases() {
        return medicalCases;
    }

    public void setMedicalCases(List<MedicalCase> medicalCases) {
        this.medicalCases = medicalCases;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }


    public int getPatientID() {
        return patientID;
    }


    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }




    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", patientName='" + patientName + '\'' +
                ", patientSurname='" + patientSurname + '\'' +
                ", medicalCases=" + medicalCases +
                '}';
    }


}
