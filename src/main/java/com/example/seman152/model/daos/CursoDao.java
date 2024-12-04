package com.example.seman152.model.daos;

import com.example.seman152.model.documents.Curso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface CursoDao extends ReactiveMongoRepository<Curso, String> {
}
