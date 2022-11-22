package org.binar.chapter6.repository;

import org.binar.chapter6.model.FilesDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilesDbRepository extends JpaRepository<FilesDb, Long> {
}
