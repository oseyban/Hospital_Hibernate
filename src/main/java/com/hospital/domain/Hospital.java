package com.hospital.domain;

import javax.persistence.*;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;
//    @OneToMany(mappedBy = "hospital", cascade = CascadeType.REMOVE)
//    private List<Doctor> doctorList;

}
