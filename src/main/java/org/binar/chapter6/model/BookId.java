package org.binar.chapter5.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BookId implements Serializable {
    private String judulBuku;
    private String penulis;
    private Integer versi;
}
