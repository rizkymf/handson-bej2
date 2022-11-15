package org.binar.chapter5.service;

import org.binar.chapter5.model.Mahasiswa;
import org.binar.chapter5.repository.MahasiswaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
public class MahasiswaServiceTest {

    @Mock
    IMahasiswaService mahasiswaService;

    @Mock
    MahasiswaRepository mahasiswaRepository;

    @BeforeEach
    void init() {
        mahasiswaService = new MahasiswaService(this.mahasiswaRepository);
    }

    @Test
    void newMahasiswa_alreadyRegistered() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama("Test Mock");
        Mockito.when(mahasiswaRepository.findMahasiswaByNama(mahasiswa.getNama())).thenReturn(Arrays.asList(mahasiswa));
        Assertions.assertThrows(Exception.class, () -> mahasiswaService.newMahasiswa(mahasiswa));
        Mockito.verify(mahasiswaRepository, Mockito.times(0)).save(Mockito.any(Mahasiswa.class));
    }

    @Test
    void newMahasiswa_success() {
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama("Test Spy");
        mahasiswa.setIdMahasiswa(20200103);
        mahasiswa.setAngkatan(2020);
        mahasiswa.setJurusan("Jurusan Test");
        mahasiswa.setKodeJurusan("00");

        Mockito.when(mahasiswaRepository.findMahasiswaByNama(mahasiswa.getNama())).thenReturn(new ArrayList<>());
        Assertions.assertDoesNotThrow(() -> mahasiswaService.newMahasiswa(mahasiswa));

        Mockito.verify(mahasiswaRepository, Mockito.times(1)).save(Mockito.any(Mahasiswa.class));
    }
}
