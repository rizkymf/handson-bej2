package org.binar.chapter6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Kelas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String namaKelas;

    private String pengajar;

    @OneToMany(mappedBy = "id")
    private List<UserActive> murid;
}
