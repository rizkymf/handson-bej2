package org.binar.chapter4.repository;

import org.binar.chapter4.model.Mahasiswa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@SpringBootTest
public class MahasiswaRepositoryTest {

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Test
    void getMahasiswaByAngkatan() {
        // cara 1 pake JPQL
        List<Mahasiswa> mahasiswaList1 = mahasiswaRepository.findMahasiswaByAngkatan(2022);
        mahasiswaList1.forEach(mhs -> {
            System.out.println(mhs.getNama());
        });

        // cara 2 pake @Query
        List<Mahasiswa> mahasiswaList2 = mahasiswaRepository.findMahasiswaByAngkatanQuery(2022);
        mahasiswaList2.forEach(mhs -> {
            System.out.println(mhs.getNama());
        });

        // cara 3 pake @Query tapi pake nativeQuery = true
        List<Mahasiswa> mahasiswaList3 = mahasiswaRepository.findMahasiswaByAngkatanNative(2022);
        mahasiswaList3.forEach(mhs -> {
            System.out.println(mhs.getNama());
        });
    }

    @Test
    void testPageableOnMahasiswa() {
        System.out.println("print mhs page 0");
        List<Mahasiswa> mahasiswaList0 = mahasiswaRepository.findAllMahasiswa(PageRequest.of(0, 2));
        mahasiswaList0.forEach(mhs -> {
            System.out.println(mhs.getNama());
        });
        System.out.println("-----------------");
        System.out.println("print mhs page 1");
        List<Mahasiswa> mahasiswaList1 = mahasiswaRepository.findAllMahasiswa(PageRequest.of(1, 2));
        mahasiswaList1.forEach(mhs -> {
            System.out.println(mhs.getNama());
        });
        System.out.println("-----------------");
        System.out.println("print mhs page 2");
        List<Mahasiswa> mahasiswaList2 = mahasiswaRepository.findAllMahasiswa(PageRequest.of(2, 2));
        mahasiswaList2.forEach(mhs -> {
            System.out.println(mhs.getNama());
        });
    }

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

    @Test
    void testChangeFakultas_storeProcedure() {
        mahasiswaRepository.changeFakultas1("01", "03");
    }
}
