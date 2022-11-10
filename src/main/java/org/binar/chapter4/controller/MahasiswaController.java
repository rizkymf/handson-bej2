package org.binar.chapter4.controller;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.binar.chapter4.model.Mahasiswa;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/test1")
    public String test1() {
        return "hallo test1 dari mahasiswa";
    }

    @GetMapping("/nametag")
    public void generateNameTag(HttpServletResponse response,
                                          @RequestParam("nama") String nama) {
        try {
            String sourceFileName = "E:\\Binar\\Synrgy\\chapter-5\\src\\main\\resources\\nametag.jasper";
//            ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "SampleJasperTemplate.jasper").getAbsolutePath()
// creating our list of beans
            List<Mahasiswa> dataMahasiswa = new ArrayList<>();
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNama("Coba asal");
            mahasiswa.setJurusan("jurusan");
            mahasiswa.setAngkatan(2022);
            dataMahasiswa.add(mahasiswa);
// creating datasource from bean list
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataMahasiswa);
            Map parameters = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(sourceFileName, parameters, beanColDataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");
        } catch(Exception e) {

        }
    }
}
