package ru.project.game_management.impl;

import ru.project.game_logic.ScoreCalculationStrategy;
import ru.project.game_logic.impl.ScoreCalculationStrategyImpl;
import ru.project.game_management.ScoreManager;
import ru.project.game_model.Match;
import ru.project.game_model.Move;

import java.util.ArrayList;
import java.util.List;

public class ScoreManagerImpl implements ScoreManager {
    private List<Move> historyOfMoves;
    private int score;
    private final ScoreCalculationStrategy strategy;

    public ScoreManagerImpl() {
        this.strategy = new ScoreCalculationStrategyImpl();
        this.historyOfMoves = new ArrayList<>();
        this.score = 0;
    }

    @Override
    public void recordMove(Move move, List<Match> matches) {
        if (move == null || matches == null || matches.isEmpty()) {
            throw new IllegalArgumentException("Move cannot be null");
        }
        historyOfMoves.add(move);
        score += strategy.calculateScore(matches);
    }

    @Override
    public List<Move> getHistoryOfMoves() {
        return historyOfMoves;
    }

    @Override
    public int getScore() {
        return this.score;
    }
}
