package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class RakBuku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String kodeRak;

    @OneToMany
    private List<Book> listBuku;
}
