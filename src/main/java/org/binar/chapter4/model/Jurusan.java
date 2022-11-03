package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Jurusan {

    @Id
    private String kodeJurusan;

    private String kodeFakultas;

    private String nama;
}
