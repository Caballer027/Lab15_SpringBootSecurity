package com.example.seman152;

import com.example.seman152.model.documents.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;


@SpringBootApplication
public class Seman152Application implements CommandLineRunner {
    @Autowired
    private ReactiveMongoTemplate template;
    public static void main(String[] args) {

        SpringApplication.run(Seman152Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        template.dropCollection("cursos").subscribe();
        //insertar cursos
        template.insert(new Curso("C01","Java 17", 4)).subscribe();
        template.insert(new Curso("C02","SPRING BOOT", 5)).subscribe();
        template.insert(new Curso("C03","Jenkins", 3)).subscribe();
        template.insert(new Curso("C04","kubernetes", 4)).subscribe();
        template.insert(new Curso("C05","kafka", 3)).subscribe();
        template.insert(new Curso("C06","microservicios", 4)).subscribe();
        template.insert(new Curso("C07","angular", 5)).subscribe();
        template.insert(new Curso("C08","typescript", 4)).subscribe();
        template.insert(new Curso("C09","html", 4)).subscribe();
        template.insert(new Curso("C10","css 3", 1)).subscribe();
    }

}
