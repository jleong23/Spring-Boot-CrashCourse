package com.jasoncode;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Integer> {

    Example<? extends SoftwareEngineer> id(Integer id);
    List<SoftwareEngineer> findByTechStack(String techStack);
}
