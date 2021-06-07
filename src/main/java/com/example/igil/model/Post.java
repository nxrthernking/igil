package com.example.igil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
    //СУЩНОСТЬ ПОСТ. ТО, ЧТО СОДЕРЖИТ В СЕБЕ ТЕМА ФОРУМА ИЗ ВЫПАДАЮЩЕГО МЕНЮ
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    @OneToMany
    private List<Comment> comments;
}
