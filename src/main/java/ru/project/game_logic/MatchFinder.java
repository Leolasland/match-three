package ru.project.game_logic;

import ru.project.core_engine.GameBoard;
import ru.project.core_engine.GameElement;
import ru.project.game_model.Match;

import java.util.List;

/**
 * Ищет комбинации и определяет бонусные.
 * <p>
 * Запросы - проверка на возможные комбинации и поиск всх возможных комбинаций.
 * <p>
 * Команды - отсутствуют, так как класс неизменяемый.
 */
public interface MatchFinder {

    /**
     * Проверяет есть ли на поле хотя бы одна возможная комбинация.
     * @param board {@link GameBoard}
     * @return true или false
     */
    boolean hasPotentialMatches(GameBoard board);

    /**
     * Найти все комбинации из 3+ элементов на текущем поле.
     * @param board {@link GameBoard}
     * @return {@link Match} список комбинаций
     */
    List<Match> findMatches(GameBoard board);
}
