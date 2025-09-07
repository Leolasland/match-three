package ru.project.game_logic;

import ru.project.game_model.Match;

import java.util.List;

/**
 * Стратегия начисления очков за комбинации, в том числе бонусные.
 * <p>
 * Запросы - рассчитать очки для набора позиций и типа элемента.
 */
public interface ScoreCalculationStrategy {

    /**
     * Расчет очков для позиций и типа элемента
     *
     * @param matches {@link Match} комбинация элементов
     * @return количество очков
     */
    int calculateScore(List<Match> matches);
}
