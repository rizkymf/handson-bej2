package org.binar.chapter5.controller;

import org.binar.chapter5.model.FilesDb;
import org.binar.chapter5.service.IFilesDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FilesDbController {

    @Autowired
    IFilesDbService filesDbService;

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        FilesDb filesDb = new FilesDb();
        try {
            filesDb.setNamaFile(multipartFile.getOriginalFilename());
            filesDb.setFile(multipartFile.getBytes());
            String result = filesDbService.uploadFile(filesDb);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch(IOException ioe) {
            return new ResponseEntity(ioe.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/download")
    public ResponseEntity downloadFile(@RequestParam("id") Long id) {
        FilesDb filesDb = filesDbService.downloadFile(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(filesDb.getFile());
    }
}
