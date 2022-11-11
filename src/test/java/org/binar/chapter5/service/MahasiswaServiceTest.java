package org.binar.chapter5.service;

import org.binar.chapter5.model.Mahasiswa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MahasiswaServiceTest {

    @Autowired
    IMahasiswaService mahasiswaService;

    @Test
    void newMahasiswa_alreadyRegistered() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama("Udin Samsyudin");
        Assertions.assertThrows(Exception.class, () -> mahasiswaService.newMahasiswa(mahasiswa));
    }
}
