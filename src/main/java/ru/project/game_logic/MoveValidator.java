package ru.project.game_logic;

import ru.project.game_model.Move;

/**
 * Проверяет корректность хода.
 * <p>
 * Запросы - проверка корректности хода.
 * <p>
 * Команды - отсутствуют.
 * <p>
 * Ограничения:
 * Ход должен быть признан валидным, только если -
 * <ol>
 * <li>Позиции находятся в пределах поля.</li>
 * <li>Позиции являются соседними.</li>
 * <li>Ход приводит хотя бы к одной комбинации.</li>
 * </ol>
 */
public interface MoveValidator {

    boolean isValid(Move move);
}
