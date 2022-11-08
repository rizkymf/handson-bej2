package org.binar.chapter4.controller;

import org.binar.chapter4.model.Mahasiswa;
import org.binar.chapter4.model.request.MahasiswaRequest;
import org.binar.chapter4.model.response.MahasiswaResponse;
import org.binar.chapter4.service.IMahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    IMahasiswaService mahasiswaService;

    @GetMapping("/test1")
    public void testController() {
        System.out.println("test controller coy");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test2")
    public String test2() {
        System.out.println("test 2");
        return "test 2 success!";
    }

    @GetMapping("/search_mhs")
    public Mahasiswa searchMhs() {
         return mahasiswaService.searchMahasiswa("Rizky");
    }

    // custom response sederhana, dengan body custom dan respon code custom
    @GetMapping("/test3")
    public ResponseEntity test3() {
        return new ResponseEntity("Sukses Choy", HttpStatus.BAD_REQUEST);
    }

    // custom response, custom response body berupa map/object, custom response header, custom httpstatus
    @GetMapping("/test4")
    public ResponseEntity test4() {
        try {
            Map<String, Object> resp = new HashMap<>();
            resp.put("message", "sucessfully processed");
            resp.put("price", 5000);

            MultiValueMap<String, String> header = new HttpHeaders();
            header.add("Type", "Header biasa aja sih");
            return new ResponseEntity(resp, header, HttpStatus.ACCEPTED);
        } catch(Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    // contoh pake pathVariable
    @GetMapping("/cari/{namaMhs}")
    public ResponseEntity cariPathVar(@PathVariable("namaMhs") String namaMhs) {
        Mahasiswa mahasiswa = mahasiswaService.searchMahasiswa(namaMhs);
        MahasiswaResponse resp = new MahasiswaResponse(mahasiswa.getNama(), mahasiswa.getJurusan(),
                mahasiswa.getAngkatan());
        return new ResponseEntity(resp, HttpStatus.OK);
    }

    // contoh pake request parameter
    @GetMapping("/cari")
    public ResponseEntity cariParam(@RequestParam("nama") String namaMhs) {
        Mahasiswa mahasiswa = mahasiswaService.searchMahasiswa(namaMhs);
        MahasiswaResponse resp = new MahasiswaResponse(mahasiswa.getNama(), mahasiswa.getJurusan(),
                mahasiswa.getAngkatan());
        return new ResponseEntity(resp, HttpStatus.OK);
    }

    @PostMapping(value = "/new_mahasiswa")
    public ResponseEntity newMahasiswa(@RequestBody MahasiswaRequest mahasiswaRequest,
                                       @RequestHeader("Kelas") String kelas) {
        Map<String, Object> resp = new HashMap<>();
        resp.put("message", "insert success!");
        resp.put("kelas", kelas);

        try {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setIdMahasiswa(20200101); // id nya asal, TODO kasih logic
            mahasiswa.setNama(mahasiswaRequest.getNama());
            mahasiswa.setAngkatan(mahasiswaRequest.getAngkatan());
            mahasiswa.setJurusan(mahasiswaRequest.getJurusan());
            mahasiswa.setKodeJurusan(mahasiswaRequest.getKodeJurusan());
            mahasiswaService.newMahasiswa(mahasiswa);
            return new ResponseEntity(resp, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            resp.put("message", "insert gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }

    }


}
