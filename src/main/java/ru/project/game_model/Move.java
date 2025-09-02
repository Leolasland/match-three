package ru.project.game_model;

import java.util.HashSet;

/**
 * Класс предоставляющий ход игрока - хотим поменять местами два элемента.
 * <p>
 * Запросы - получить {@link Position} from или to.
 * <p>
 * Команды - отсутствуют, так как класс неизменяемый.
 * <p>
 * Ограничения:
 * <li> Позиции `from` и `to` не должны быть null.
 * <li> Позиции `from` и `to` не должны быть одинаковыми.
 */
public record Move(Position from, Position to) {

    /**
     * Создаем ход из двух позиций.
     *
     * @param from {@link Position} позиция первого элемента
     * @param to   {@link Position} позиция второго элемента
     */
    public Move {
        if (from == null || to == null || from.equals(to)) {
            throw new IllegalArgumentException();
        }
    }
}
