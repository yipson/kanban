package com.techm.board.service;

import com.techm.board.domain.Board;
import com.techm.board.domain.Task;
import com.techm.board.domain.User;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    Board showBoardByUserId(Long userId);

}
