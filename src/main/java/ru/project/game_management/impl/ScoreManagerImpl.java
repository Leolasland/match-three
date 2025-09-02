package ru.project.game_management.impl;

import ru.project.game_management.ScoreManager;
import ru.project.game_model.Move;

import java.util.List;

public class ScoreManagerImpl implements ScoreManager {
    private List<Move> historyOfMoves;
    private int score;

    @Override
    public void recordMove(Move move, int score) {

    }

    @Override
    public List<Move> getHistoryOfMoves() {
        return historyOfMoves;
    }

    @Override
    public int getScore() {
        return score;
    }
}
