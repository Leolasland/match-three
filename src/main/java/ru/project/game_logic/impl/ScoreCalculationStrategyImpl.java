package ru.project.game_logic.impl;

import ru.project.game_logic.ScoreCalculationStrategy;
import ru.project.game_model.Match;

import java.util.List;

public class ScoreCalculationStrategyImpl implements ScoreCalculationStrategy {

    public static final int BASE_SCORE = 10;
    public static final int LONG_SCORE = 20;
    public static final int BONUS_SCORE = 50;

    @Override
    public int calculateScore(List<Match> matches) {
        int score = 0;
        for (Match match : matches) {
            int matchSize = match.positions().size();
            score += matchSize * BASE_SCORE;
            if (matchSize >= 4) {
                score += LONG_SCORE;
            }
            if (match.gameElement().isBonus()) {
                score += BONUS_SCORE;
            }
        }
        return score;
    }
}
