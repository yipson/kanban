package com.techm.board.controller;

import com.techm.board.client.UserClient;
import com.techm.board.domain.Board;
import com.techm.board.domain.User;
import com.techm.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path= "board")
public class BoardController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private BoardService boardService;

    @GetMapping(path= "{userId}")
    public Board getBoard(
            @PathVariable("userId") Long userId){
        return boardService.showBoardByUserId(userId);
    }

    @GetMapping(path = "user")
    public List<User> listUsers(){
        return userClient.listUsers();
    }

}
