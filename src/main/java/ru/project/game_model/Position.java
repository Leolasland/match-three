package ru.project.game_model;

import ru.project.core_engine.GameBoard;

/**
 * Класс предоставляющий координаты на игровом поле.
 * <p>
 * Запросы - получить row или column.
 * <p>
 * Команды - Отсутствуют, так как класс неизменяемый.
 * <p>
 * Ограничения:
 * <li> Все создаваемые объекты должны иметь координаты в пределах [0, GameBoard.SIZE - 1]
 * <li> Класс является неизменяемым (immutable). После создания его состояние нельзя изменить.
 */
public record Position(int row, int column) {

    /**
     * Создаем позицию из координат.
     *
     * @param row    номер строки (начинается с 0, максимум задается в {@link GameBoard})
     * @param column номер столбца (начинается с 0, максимум задается в {@link GameBoard})
     */
    public Position {
        if (row < 0 || row > GameBoard.SIZE || column < 0 || column > GameBoard.SIZE) {
            throw new IllegalArgumentException();
        }
    }

}
