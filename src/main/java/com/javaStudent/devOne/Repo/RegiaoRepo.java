package com.javaStudent.devOne.Repo;

import com.javaStudent.devOne.Entity.Regiao;
import org.springframework.data.jpa.repository.JpaRepository; /*extender atraves da interface para o JPA repository */


public interface RegiaoRepo extends JpaRepository<RegiaoRepo, Long> {
}
