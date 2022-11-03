package org.binar.chapter4.service;

import org.binar.chapter4.model.Mahasiswa;
import org.binar.chapter4.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Scanner;

@Service
public class MenuService {

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    public void init(Scanner scan) {
        System.out.println("Aplikasi manajemen mahasiswa, silahkan pilih menu\n" +
                "1. Input mahasiswa Baru\n" +
                "2. Delete mahasiswa\n" +
                "0. Keluar");
        System.out.print("=> ");
        byte input = scan.nextByte();
        scan.nextLine();
        switch(input) {
            case 1:
                inputMahasiswa(scan);
                init(scan);
                break;
            case 2:
//                deleteMahasiswa(scan);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public void inputMahasiswa(Scanner scan) {
        Mahasiswa mahasiswa = new Mahasiswa();
        System.out.print("Nama : ");
        String nama = scan.nextLine();
        mahasiswa.setNama(nama);

        System.out.print("Jurusan : ");
        String jurusan = scan.nextLine();
        mahasiswa.setJurusan(jurusan);

        System.out.print("Kode jurusan : ");
        String kodeJurusan = scan.nextLine();
        mahasiswa.setKodeJurusan(kodeJurusan);

        Integer angkatan = LocalDate.now().getYear();
        mahasiswa.setAngkatan(angkatan);

        String idMhs = String.valueOf(angkatan).trim() + kodeJurusan.trim() + "001";
        mahasiswa.setIdMahasiswa(Integer.valueOf(idMhs));

        mahasiswaRepository.save(mahasiswa);
    }
}
