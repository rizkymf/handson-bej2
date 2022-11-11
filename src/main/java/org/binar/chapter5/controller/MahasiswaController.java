package org.binar.chapter5.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.binar.chapter5.model.Mahasiswa;
import org.binar.chapter5.service.IMahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    IMahasiswaService mahasiswaService;

    @GetMapping("/test1")
    public String test1() {
        return "hallo test1 dari mahasiswa";
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
}
