package org.binar.chapter6.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.binar.chapter6.model.Mahasiswa;
import org.binar.chapter6.model.request.MahasiswaRequest;
import org.binar.chapter6.model.response.MahasiswaResponse;
import org.binar.chapter6.service.IMahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
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
    public ResponseEntity cariPathVar(@Schema(example = "Rizky") @PathVariable("namaMhs") String namaMhs) {
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

    // contoh post dengan body dan header
    @Operation(summary = "untuk menambahkan mahasiswa baru ke dalam sistem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "return yang didapat jika request success",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MahasiswaResponse.class))})
    })
    @PostMapping(value = "/new_mahasiswa")
    public ResponseEntity newMahasiswa(@Valid @RequestBody MahasiswaRequest mahasiswaRequest,
                                       @Schema(example = "BEJ 2 Synrgy") @Nullable @RequestHeader("Kelas") String kelas) {
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
