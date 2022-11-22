package org.binar.chapter6.repository;

import org.binar.chapter6.model.UserActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActiveRepository extends JpaRepository<UserActive, Integer> {
}
