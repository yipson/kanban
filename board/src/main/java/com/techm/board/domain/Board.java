package com.techm.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Board implements Serializable {

    private Long userId;
    private String userFullName;
    private List<Task> tasks;

    public Board() {
    }

    public Board(Long userId,
                 String userFullName,
                 List<Task> tasks) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.tasks = tasks;
    }
}
