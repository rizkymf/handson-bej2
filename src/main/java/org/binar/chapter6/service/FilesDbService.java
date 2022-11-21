package org.binar.chapter5.service;

import org.binar.chapter5.model.FilesDb;
import org.binar.chapter5.repository.FilesDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilesDbService implements IFilesDbService {

    @Autowired
    FilesDbRepository filesDbRepository;

    @Override
    public String uploadFile(FilesDb filesDb) {
        try {
            filesDbRepository.save(filesDb);
            return "Upload success";
        } catch(Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public FilesDb downloadFile(Long id) {
        return filesDbRepository.findById(id).orElse(null);
    }
}
