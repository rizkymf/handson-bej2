package org.binar.chapter6.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaResponse {
    private String nama;
    private String jurusan;
    private Integer angkatan;
}
