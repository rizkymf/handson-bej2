package org.binar.chapter5.repository;

import org.binar.chapter5.model.FilesDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesDbRepository extends JpaRepository<FilesDb, Long> {
}
