package org.binar.chapter4.repository;

import org.binar.chapter4.model.Mahasiswa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MahasiswaRepositoryTest {

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Test
    void insertMahasiswa() {
        // data mahasiswa yang akan di insert
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setJurusan("Administrasi Bisnis");
        mahasiswa.setNama("Udin Samsyudin");
        mahasiswa.setAngkatan(2022);
        mahasiswa.setKodeJurusan("02");

        // save data mahasiswa ke table mahasiswa
        mahasiswaRepository.save(mahasiswa);
    }
}
