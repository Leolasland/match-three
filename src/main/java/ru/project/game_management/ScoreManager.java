package ru.project.game_management;

import ru.project.game_model.Move;

import java.util.List;

/**
 * Ведет подсчет очков и историю ходов.
 * Счет не может уменьшаться. Ходы нельзя отменять.
 * <p>
 * Запросы - получение итогового счета и всей истории ходов.
 * <p>
 * Команды - добавление ход для истории и счета.
 * <p>
 * Ограничения:
 * <li> Добавляемый ход не может быть null.
 * <li> Добавляемое количество очков не может быть отрицательным или равно нулю.
 */
public class ScoreManager {

    private List<Move> historyOfMoves;
    private int score;

    /**
     * Добавляем ход для истории и счет
     * @param move ход {@link Move}
     * @param score сколько очков добавляется к счету. Не может быть меньше или равен нуля.
     */
    public void recordMove(Move move, int score) {

    }

    /**
     * Получить всю историю ходов.
     * @return упорядоченный список ходов {@link Move}
     */
    public List<Move> getHistoryOfMoves() {
        return historyOfMoves;
    }

    /**
     * Получить итоговый счет
     * @return количество очков
     */
    public int getScore() {
        return score;
    }
}
