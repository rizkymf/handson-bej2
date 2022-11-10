package org.binar.chapter4.service;

import org.binar.chapter4.model.FilesDb;

public interface IFilesDbService {
    String uploadFile(FilesDb filesDb);
    FilesDb downloadFile(Long id);
}
