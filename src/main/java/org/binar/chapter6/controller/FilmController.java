package org.binar.chapter6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmController {

    @PostMapping("/admin/add-film")
    public void tambahFilm() {

    }

    @GetMapping("/public/get-film")
    public void tampilFilmTayang() {

    }

    @PostMapping("/customer/get-invoice")
    public void getInvoice() {

    }
}
