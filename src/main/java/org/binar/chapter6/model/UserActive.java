package org.binar.chapter6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserActive {

    // nomor_hape
    // NOMOR_HAPE
    // nomorHape

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nama;

    private String email;

    private String nomorHape;

    @Transient
    private boolean state;

}
