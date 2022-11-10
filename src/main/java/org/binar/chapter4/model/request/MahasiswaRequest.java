package org.binar.chapter4.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MahasiswaRequest {

    @NonNull
    @Schema(example = "Rizky")
    private String nama;

    @NonNull
    @Schema(example = "Teknik Informatika")
    private String jurusan;

    @Schema(example = "2020")
    private Integer angkatan;

    @Schema(example = "001")
    private String kodeJurusan;
}
