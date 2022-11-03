package org.binar.chapter4.repository;

import org.binar.chapter4.model.Jurusan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface JurusanRepository extends JpaRepository<Jurusan, String> {

    @Modifying
    @Query(value = "CALL CHANGE_FAKULTAS(:fakultasFrom, :fakultasTo)", nativeQuery = true)
    void changeFakultas1(@Param("fakultasFrom") String fakultasFrom, @Param("fakultasTo") String fakultasTo);

}
