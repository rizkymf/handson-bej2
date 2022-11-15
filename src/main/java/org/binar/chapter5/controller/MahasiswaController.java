package org.binar.chapter5.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.fonts.SimpleFontFamily;
import org.binar.chapter5.model.Mahasiswa;
import org.binar.chapter5.model.request.MahasiswaRequest;
import org.binar.chapter5.model.response.MahasiswaResponse;
import org.binar.chapter5.service.IMahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    IMahasiswaService mahasiswaService;

    @GetMapping("/test1")
    public String test1() {
        return "hallo test1 dari mahasiswa";
    }

    @GetMapping("/search_mahasiswa")
    public ResponseEntity searchMahasiswa(@RequestParam("nama") String nama,
                                          @RequestParam("angkatan") Integer angkatan) {
        Mahasiswa mahasiswa = mahasiswaService.searchMahasiswaWithAngkatan(nama, angkatan);
        return new ResponseEntity(mahasiswa, HttpStatus.OK);
    }

    @GetMapping("/nametag")
    public void generateNameTag(HttpServletResponse response,
                                          @RequestParam("nama") String nama) {
        try {
            JasperReport sourceFileName = JasperCompileManager.compileReport
                    (ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "nametag.jrxml").getAbsolutePath());

            // creating our list of beans
            List<Map<String,String>> dataMahasiswa = new ArrayList<>();
            Map<String, String> mhs = new HashMap<>();
            Mahasiswa mahasiswa = mahasiswaService.searchMahasiswa(nama);
            mhs.put("namaMahasiswa", mahasiswa.getNama());
            mhs.put("angkatan", String.valueOf(mahasiswa.getAngkatan()));
            mhs.put("jurusan", mahasiswa.getJurusan());
            mhs.put("testBarcode", "Hello Binar Synrgy 5 BEJ 2");
            mhs.put("test", "Name Tag");
            dataMahasiswa.add(mhs);

        // creating datasource from bean list
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataMahasiswa);
            Map<String,Object> parameters = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);

            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=nametag.pdf;");

            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

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
            mahasiswa.setIdMahasiswa(Integer.valueOf(LocalDate.now().getYear()
                    + String.valueOf(mahasiswaRequest.getKodeJurusan()))); // id nya asal, TODO kasih logic
            mahasiswa.setNama(mahasiswaRequest.getNama());
            mahasiswa.setAngkatan(mahasiswaRequest.getAngkatan());
            mahasiswa.setJurusan(mahasiswaRequest.getJurusan());
            mahasiswa.setKodeJurusan(mahasiswaRequest.getKodeJurusan());
            mahasiswaService.newMahasiswa(mahasiswa);
            return new ResponseEntity(resp, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("message", "insert gagal!, dikarenakan : " + e.getMessage());
            return new ResponseEntity(resp, HttpStatus.BAD_GATEWAY);
        }

    }

    @GetMapping("/invoice_pembayaran")
    public void generateInvoiceBayar(HttpServletResponse response,
                                @RequestParam("nama") String nama) {
        try {
            JasperReport sourceFileName = JasperCompileManager.compileReport
                    (ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "demoReport.jrxml").getAbsolutePath());

            // creating our list of beans
            List<Map<String,Object>> dataMahasiswa = new ArrayList<>();
            Map<String, Object> mhs = new HashMap<>();
            Mahasiswa mahasiswa = mahasiswaService.searchMahasiswa(nama);
            mhs.put("namaMahasiswa", mahasiswa.getNama());
            mhs.put("idMahasiswa", mahasiswa.getIdMahasiswa());
            mhs.put("semester", "5");
            mhs.put("biayaKuliah", "5.000.000");
            dataMahasiswa.add(mhs);

            // creating datasource from bean list
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataMahasiswa);
            Map<String,Object> parameters = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);

            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=nametag.pdf;");

            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
