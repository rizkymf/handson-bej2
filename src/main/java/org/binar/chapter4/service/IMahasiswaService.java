package org.binar.chapter4.service;

import org.binar.chapter4.model.Mahasiswa;
import org.springframework.stereotype.Service;

@Service
public interface IMahasiswaService {

    void newMahasiswa(Mahasiswa mahasiswa) throws Exception;
    Mahasiswa searchMahasiswa(String nama);

}
