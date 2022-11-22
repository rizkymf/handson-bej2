package org.binar.chapter6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Fakultas {

    @Id
    private String kodeFakultas;

    private String nama;
}
