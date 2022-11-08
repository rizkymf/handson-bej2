package org.binar.chapter4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @GetMapping("/test1")
    public String test1() {
        return "hallo test1 dari mahasiswa";
    }
}
