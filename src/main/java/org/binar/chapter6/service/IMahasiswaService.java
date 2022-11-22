package org.binar.chapter6.service;

import org.binar.chapter6.model.Mahasiswa;
import org.springframework.stereotype.Service;

@Service
public interface IMahasiswaService {

    void newMahasiswa(Mahasiswa mahasiswa) throws Exception;
    Mahasiswa searchMahasiswa(String nama);
    Mahasiswa searchMahasiswaWithAngkatan(String nama, Integer angkatan);

}
