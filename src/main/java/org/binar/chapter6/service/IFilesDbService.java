package org.binar.chapter6.service;

import org.binar.chapter6.model.FilesDb;

public interface IFilesDbService {
    String uploadFile(FilesDb filesDb);
    FilesDb downloadFile(Long id);
}
