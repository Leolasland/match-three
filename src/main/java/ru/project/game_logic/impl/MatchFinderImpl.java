package ru.project.game_logic.impl;

import ru.project.core_engine.GameBoard;
import ru.project.game_logic.MatchFinder;
import ru.project.game_model.Match;

import java.util.List;

public class MatchFinderImpl implements MatchFinder {

    @Override
    public boolean hasPotentialMatches(GameBoard board) {
        return false;
    }

    @Override
    public List<Match> findMatches(GameBoard board) {
        return List.of();
    }
}
