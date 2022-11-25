package org.binar.chapter6.service;

import lombok.extern.slf4j.Slf4j;
import org.binar.chapter6.service.IFilesDbService;
import org.binar.chapter6.model.FilesDb;
import org.binar.chapter6.repository.FilesDbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FilesDbService implements IFilesDbService {

//    private Logger LOG = LoggerFactory.getLogger(FilesDbService.class);

    @Autowired
    FilesDbRepository filesDbRepository;

    @Override
    public String uploadFile(FilesDb filesDb) {
        try {
            filesDbRepository.save(filesDb);
            return "Upload success";
        } catch(Exception e) {
            log.error("ERROR has been found! because : {}", e.getMessage());
            return e.getMessage();
        }
    }

    @Override
    public FilesDb downloadFile(Long id) {
        log.info("downloading file with id {} {}", id, "UHUY");
        log.error("ini error yang dipasang disini ajah");
        return filesDbRepository.findById(id).orElse(null);
    }
}
