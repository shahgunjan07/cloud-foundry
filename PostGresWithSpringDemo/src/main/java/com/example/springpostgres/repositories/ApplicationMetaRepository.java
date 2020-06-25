package com.example.springpostgres.repositories;

import com.example.springpostgres.models.ApplicationMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationMetaRepository extends JpaRepository<ApplicationMeta, String> {
     ApplicationMeta findByName(String name);
}
