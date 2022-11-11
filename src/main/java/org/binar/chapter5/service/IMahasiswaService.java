package org.binar.chapter5.service;

import org.binar.chapter5.model.Mahasiswa;
import org.springframework.stereotype.Service;

@Service
public interface IMahasiswaService {

    void newMahasiswa(Mahasiswa mahasiswa) throws Exception;
    Mahasiswa searchMahasiswa(String nama);

}
