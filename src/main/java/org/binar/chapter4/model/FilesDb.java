package org.binar.chapter4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilesDb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String namaFile;

    @Lob
    private byte[] file;

}
