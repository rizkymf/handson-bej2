package org.binar.chapter4.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaRequest {
    private String nama;
    private String jurusan;
    private Integer angkatan;
    private String kodeJurusan;
}
