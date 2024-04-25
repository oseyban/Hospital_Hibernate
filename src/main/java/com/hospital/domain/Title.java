package com.hospital.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private  String titleName;


    @OneToMany(mappedBy="title")
    private List<Doctor> doctorList=new ArrayList<>();

    @OneToMany(mappedBy = "title")
    private List<MedicalCase> medicalCase=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public List<MedicalCase> getMedicalCase() {
        return medicalCase;
    }

    public void setMedicalCase(List<MedicalCase> medicalCase) {
        this.medicalCase = medicalCase;
    }

    @Override
    public String toString() {
        return "Title{" +
                "id=" + id +
                ", titleName='" + titleName + '\'' +
                ", doctorList=" + doctorList +
                ", medicalCase=" + medicalCase +
                '}';
    }
}
