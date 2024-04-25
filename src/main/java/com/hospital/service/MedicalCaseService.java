package com.hospital.service;

import com.hospital.domain.MedicalCase;

public class MedicalCaseService {


    public MedicalCase findMedicalCase() {


        return medicalCase;
    }


    /*public MedicalCase findPatientCase(String aktuelDurum) {
        MedicalCase medicalCase = new MedicalCase("Yanlis Durum", "Geçersiz Durum");
        switch (aktuelDurum.toLowerCase()) {
            case "allerji":
            case "bas agrisi":
            case "diabet":
            case "soguk alginligi":
                medicalCase.setEmergency(" acil bir durum değil");
                medicalCase.setActualCase(aktuelDurum);
                //   medicalCase.setDoctor(doctorService.findDoctorById(sayi));
                break;
            case "migren":
            case "kalp hastaliklari":
                medicalCase.setEmergency(" acil durum");
                medicalCase.setActualCase(aktuelDurum);
                break;
            default:
                System.out.println("Gecerli bir durum degil");
        }
        return medicalCase;
    }

     */
}
