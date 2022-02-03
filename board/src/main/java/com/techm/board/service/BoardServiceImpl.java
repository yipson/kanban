package com.techm.board.service;

import com.techm.board.client.TaskClient;
import com.techm.board.client.UserClient;
import com.techm.board.domain.Board;
import com.techm.board.domain.Task;
import com.techm.board.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private UserClient userClient;

    @Autowired
    private TaskClient taskClient;

    @Override
    public Board showBoardByUserId(Long userId) {

        Optional<User> userOptional = userClient.getOneUser(userId);

        if(!userOptional.isPresent()){
            throw new IllegalStateException("Usre with id " + userId + " does not exist");
        }

        Board board = new Board(
                userId,
                userOptional.get().getName() +" "+ userOptional.get().getLastName(),
                taskClient.tasksByUserId(userId));

        return board;
    }

}
