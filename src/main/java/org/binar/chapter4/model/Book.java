package org.binar.chapter4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Book {

    @EmbeddedId
    private BookId bookId;
//    private String judulBuku;
//    private String penulis;
//    private Integer versi;
    private Integer tahunRilis;
    private Long harga;
}
