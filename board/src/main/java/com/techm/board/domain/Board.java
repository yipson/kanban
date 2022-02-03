package com.techm.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BoardDTO implements Serializable {

    private Long userId;
    private String userFullName;
    private List<Task> Tasks;

}
