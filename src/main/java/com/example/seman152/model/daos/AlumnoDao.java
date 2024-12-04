package com.example.seman152.model.daos;

import com.example.seman152.model.documents.Alumno;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AlumnoDao extends ReactiveMongoRepository<Alumno, String> {
}
