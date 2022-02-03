package com.techm.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Task implements Serializable {

    private Long id;
    private String description;
    private Status status;
    private Long idUser;

    public Task() {
    }

    public Task(String description,
                Status status) {
        this.description = description;
        this.status = status;
    }

    public Task(String description,
                Status status,
                Long idUser) {
        this.description = description;
        this.status = status;
        this.idUser = idUser;
    }

    public Task(Long id,
                String description,
                Status status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Task(Long id,
                String description,
                Status status,
                Long idUser) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.idUser = idUser;
    }
}
