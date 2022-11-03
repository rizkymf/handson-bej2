package org.binar.chapter4.menu;

import org.binar.chapter4.model.Mahasiswa;
import org.binar.chapter4.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Service
public class Menu {

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
                System.exit(0);
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
//        scan.next();
        mahasiswa.setNama(nama);

        System.out.print("Jurusan : ");
        String jurusan = scan.nextLine();
//        scan.next();
        mahasiswa.setJurusan(jurusan);
//        System.out.println();

        System.out.print("Kode jurusan : ");
        String kodeJurusan = scan.nextLine();
//        scan.next();
        mahasiswa.setKodeJurusan(kodeJurusan);

        Integer angkatan = LocalDate.now().getYear();
        mahasiswa.setAngkatan(angkatan);

        String idMhs = String.valueOf(angkatan).trim() + kodeJurusan.trim() + "001";
        mahasiswa.setIdMahasiswa(Integer.valueOf(idMhs));

        mahasiswaRepository.save(mahasiswa);
    }
}
