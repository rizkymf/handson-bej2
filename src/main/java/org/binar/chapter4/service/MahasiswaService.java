package org.binar.chapter4.service;

import org.binar.chapter4.model.Mahasiswa;
import org.binar.chapter4.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaService implements IMahasiswaService{

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Override
    public void newMahasiswa(Mahasiswa mahasiswa) throws Exception {
        // validasi dulu mahasiswa nya ada atau engga di sistem induk atau mahasiswa sudah terdaftar
        List<Mahasiswa> mhs = mahasiswaRepository.findMahasiswaByNama(mahasiswa.getNama());
        if(mhs.size() > 0) {
            throw new Exception("Mahasiswa sudah terdaftar sebelumnya!");
        }

        // ...
        mahasiswaRepository.save(mahasiswa);
    }

    @Override
    public Mahasiswa searchMahasiswa(String nama) {
        return mahasiswaRepository.findMahasiswaByNama(nama).get(0);
    }
}
