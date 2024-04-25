package com.hospital.controller;

ackage Hospital_Project.controller;

import java.io.IOException;
import java.sql.SQLException;

import static com.hospital.service.HospitalService.hospitalService;


public class HospitalRunner {
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        hospitalService.start();
    }

}


