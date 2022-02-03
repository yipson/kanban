package com.techm.board.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BoardDTO implements Serializable {

    private User user;
    private Task task;

}
