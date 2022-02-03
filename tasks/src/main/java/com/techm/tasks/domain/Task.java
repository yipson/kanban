package com.techm.tasks.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Column(name= "id_user")
    private Long idUser;

    public Task() {
    }

    public Task(String description, Status status) {
        this.description = description;
        this.status = status;
    }

    public Task(String description, Status status, Long idUser) {
        this.description = description;
        this.status = status;
        this.idUser = idUser;
    }

    public Task(Long id, String description, Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Task(Long id, String description, Status status, Long idUser) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.idUser = idUser;
    }
}
