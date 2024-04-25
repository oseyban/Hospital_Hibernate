package com.hospital.service;


import com.hospital.domain.Doctor;
import com.hospital.domain.Patient;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.TitleRepository;
import com.hospital.service.PatientService;

import javax.print.Doc;
import java.util.List;
import java.util.Scanner;

public class DoctorService{

    private final Scanner scanner = new Scanner(System.in);

    private final DoctorRepository doctorRepository;
    private final PatientService patientService;

    private final TitleService titleService;


    public DoctorService(DoctorRepository doctorRepository, PatientService patientService, TitleService titleService) {
        this.doctorRepository = doctorRepository;
        this.patientService = patientService;
        this.titleService = titleService;
    }

    public void saveDoctor() {
        Doctor doctor = new Doctor();
        System.out.println("Enter doctor name : ");
        doctor.setDoctorName(scanner.nextLine());

        System.out.println("Enter doctor lastname : ");
        doctor.setDoctorSurname(scanner.nextLine());

        //System.out.println("Enter doctor title : ");
        doctor.setTitle(titleService.findTitleByName());
        //titleService.saveTitle();

        //System.out.println("Enter doctor department : ");
        //doctor.setDepartment(scanner.nextLine());

        doctorRepository.save(doctor);
        System.out.println("Doctor was saved successfully!!");
    }

    public Doctor findDoctorById(Long id) {
        Doctor foundDoctor = doctorRepository.find(id);
        if(foundDoctor != null){
            System.out.println("-------------------");
            System.out.println(foundDoctor);
            System.out.println("-------------------");
        }else {
            System.out.println("Doctor could not found");
        }
        return foundDoctor;
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = findDoctorById(id);
        doctorRepository.delete(doctor);
        System.out.println("Doctor was deleted successfully!! Doctor ID : " + doctor.getId());
    }

    public void findAllDoctor() {
        List<Doctor> doctorList = doctorRepository.findAll();
        System.out.println("********** ALL DOCTORS *******");
        for(Doctor doctor: doctorList){
            System.out.println(doctor);
        }
        System.out.println("****************************");
    }

    public void addPatientToDoctor() {
        System.out.println("Enter the doctor ID : ");
        Long id = doctorRepository.find(scanner.nextLong()).getId();
        System.out.println("Enter the patient ID : ");
        Patient patient = patientService.findPatientById(scanner.nextLong());
        doctorRepository.addPatientToDoctor(patient,id);
        System.out.println("Patient was successfully added!! Patient ID : " + patient.getPatientID());
    }
}