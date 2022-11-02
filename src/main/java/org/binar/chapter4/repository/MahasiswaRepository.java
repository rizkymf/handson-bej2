package org.binar.chapter4.repository;

import org.binar.chapter4.model.Mahasiswa;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {

    // format query : find<ObjectYgMauDiGet>By<WhereNyaApa>OrderBy<OrderByColumnApa>
    public List<Mahasiswa> findMahasiswaByAngkatan(Integer angkatan);

    // query biasa, tapi isi query nya ngikutin object di java
    @Query(value = "SELECT m FROM Mahasiswa m WHERE angkatan = :angkatan")
    public List<Mahasiswa> findMahasiswaByAngkatanQuery(@Param("angkatan") Integer angkatan);

    // query biasa, bener2 copas sama yg dari db editor
    @Query(value = "select * from mahasiswa where angkatan = ?1", nativeQuery = true)
    public List<Mahasiswa> findMahasiswaByAngkatanNative(Integer angkatan);

    @Query(value = "select * from mahasiswa where nama = :nama", nativeQuery = true)
    public List<Mahasiswa> findMahasiswaByNama(@Param("nama") String nama);

    // get semua mahasiswa dengan pagination
    @Query(value = "select * from mahasiswa", nativeQuery = true)
    public List<Mahasiswa> findAllMahasiswa(Pageable pageable);

    // menghubungkan store procedure di db dengan java
    @Procedure("change_fakultas")
    public void changeFakultas(String fakultasFrom, String fakultasTo);

    @Query(value = "CALL CHANGE_FAKULTAS(:fakultasFrom, :fakultasTo)", nativeQuery = true)
    void changeFakultas1(@Param("fakultasFrom") String fakultasFrom, @Param("fakultasTo") String fakultasTo);
}
