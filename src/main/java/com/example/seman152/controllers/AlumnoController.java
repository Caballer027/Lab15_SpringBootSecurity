package com.example.seman152.controllers;

import com.example.seman152.model.daos.AlumnoDao;
import com.example.seman152.model.documents.Alumno;
import com.example.seman152.model.documents.Curso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class AlumnoController {
    @Autowired
    private AlumnoDao dao;

    private static final Logger log = LoggerFactory.getLogger(CursoController.class);

    @GetMapping({"/listar", "/"})
    public String listar(Model model) {

        Flux<Alumno> alumnos = dao.findAll().map(alumno -> {
            alumno.nombre().toUpperCase();
            return alumno;
        });

        alumnos.subscribe(alumno -> log.info(alumno.nombre()));

        model.addAttribute("Alumno", alumnos);
        model.addAttribute("titulo", "Listado de Alumnos");
        return "listar";
    }

    @GetMapping("/listar-datadriver")
    public String listarDataDriver(Model model) {

        Flux<Alumno> alumnos = dao.findAll().map(alumno -> {

            alumno.nombre().toUpperCase();
            return alumno;
        }).delayElements(Duration.ofSeconds(2));

        alumnos.subscribe(prod -> log.info(prod.nombre()));

        model.addAttribute("Alumnos", new ReactiveDataDriverContextVariable(alumnos, 2));
        model.addAttribute("titulo", "Listado de Alumnos");
        return "listar";
    }

    @GetMapping("/listar-full")
    public String listarFull(Model model) {

        Flux<Alumno> alumnos = dao.findAll().map(alumno -> {

            alumno.nombre().toUpperCase();
            return alumno;
        }).repeat(5000);

        model.addAttribute("Alumnos", alumnos);
        model.addAttribute("titulo", "Listado de alumnos");
        return "listar";
    }

    @GetMapping("/listar-chunked")
    public String listarChunked(Model model) {

        Flux<Alumno> alumnos = dao.findAll().map(alumno -> {

            alumno.nombre().toUpperCase();
            return alumno;
        }).repeat(5000);

        model.addAttribute("cursos", alumnos);
        model.addAttribute("titulo", "Listado de cursos");
        return "listar-chunked";
    }
}
