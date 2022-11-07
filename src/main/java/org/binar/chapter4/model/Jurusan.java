package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Jurusan {

    // kodeJurusan, nama, {kode_fakultas, nama}

    @Id
    private String kodeJurusan;

    private String nama;

    @OneToMany
//    @JoinColumn(name = "kodeFakultas")
    private List<Fakultas> kodeFakultas;
}