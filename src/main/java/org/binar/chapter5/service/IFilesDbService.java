package org.binar.chapter5.service;

import org.binar.chapter5.model.FilesDb;

public interface IFilesDbService {
    String uploadFile(FilesDb filesDb);
    FilesDb downloadFile(Long id);
}
