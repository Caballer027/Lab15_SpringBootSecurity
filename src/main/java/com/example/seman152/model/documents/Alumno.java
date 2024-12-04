package com.example.seman152.model.documents;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alumno")
public record Alumno(String id, String nombre, String apellido, int edad) {
}
