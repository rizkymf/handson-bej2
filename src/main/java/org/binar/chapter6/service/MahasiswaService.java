package org.binar.chapter6.service;

import org.binar.chapter6.model.Mahasiswa;
import org.binar.chapter6.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MahasiswaService implements IMahasiswaService{

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    public MahasiswaService() {

    }

    public MahasiswaService(MahasiswaRepository mahasiswaRepository) {
        this.mahasiswaRepository = mahasiswaRepository;
    }

    @Override
    public void newMahasiswa(Mahasiswa mahasiswa) throws Exception {
//        Mahasiswa[] maha = new Mahasiswa[10];
//        List<Mahasiswa> mahasiswaList = Arrays.asList(maha);
//        mahasiswaRepository.saveAll(mahasiswaList);
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

    @Override
    public Mahasiswa searchMahasiswaWithAngkatan(String nama, Integer angkatan) {
        return mahasiswaRepository.findMahasiswaByNamaAndAngkatan(nama, angkatan).get(0);
    }
}
