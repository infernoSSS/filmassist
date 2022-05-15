package com.filmassist.filmassist.repository;

import com.filmassist.filmassist.model.UserClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClassRepository extends JpaRepository<UserClass, Long> {
}
