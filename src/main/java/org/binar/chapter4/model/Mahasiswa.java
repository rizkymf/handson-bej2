package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Mahasiswa {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMahasiswa;

    private String nama;

    private String jurusan;

    private Integer angkatan;

    private String kodeJurusan;

    @ManyToOne
    private Kelas kelas;
}
