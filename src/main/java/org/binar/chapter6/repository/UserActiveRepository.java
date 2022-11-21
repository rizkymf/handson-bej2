package org.binar.chapter5.repository;

import org.binar.chapter5.model.UserActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActiveRepository extends JpaRepository<UserActive, Integer> {
}
