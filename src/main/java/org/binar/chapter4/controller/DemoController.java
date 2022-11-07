package org.binar.chapter4.controller;

import org.binar.chapter4.model.Mahasiswa;
import org.binar.chapter4.repository.MahasiswaRepository;
import org.binar.chapter4.service.IMahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
