package org.bogdyan.todoapp.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "todos")
@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private boolean completed = false; //false by default

}
