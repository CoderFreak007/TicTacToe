package org.practice.service;

import org.practice.model.Board;

public interface RuleService {

    public boolean isGameOver(Board board);

    public boolean isGameWon(Board board);
}
