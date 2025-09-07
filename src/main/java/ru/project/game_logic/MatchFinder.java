package ru.project.game_logic;

import ru.project.core_engine.GameBoard;
import ru.project.game_model.Match;

import java.util.List;

/**
 * Ищет комбинации.
 * <p>
 * Запросы - поиск всх возможных комбинаций.
 * <p>
 * Команды - отсутствуют, так как класс неизменяемый.
 */
public interface MatchFinder {

    /**
     * Найти все комбинации из 3+ элементов на текущем поле.
     *
     * @param board {@link GameBoard}
     * @return {@link Match} список комбинаций
     */
    List<Match> findMatches(GameBoard board);
}
