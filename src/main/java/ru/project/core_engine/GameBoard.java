package ru.project.core_engine;

import ru.project.game_model.Move;
import ru.project.game_model.Position;

/**
 * Игровое поле, хранит и обновляет состояние
 * Размер игрового поля - 8 элементов.
 * <p>
 * Запросы - получить текущее состояние доски и проверить является ли клетка на позиции пустой.
 * <p>
 * Команды - поменять элементы местами и установка, удаление элемента на позиции.
 * <p>
 * Ограничения - запросы и команды обращающиеся за пределы игрового поля невозможны.
 */
public interface GameBoard {

    int SIZE = 7;

    /**
     * Возвращает текущее состояние доски
     * @return GameBoard
     */
    GameBoard getBoard();

    /**
     * Является ли клетка на позиции {@link Position} пустой
     * @return true или false
     */
    boolean isEmpty(Position position);

    /**
     * Установка элемент на позицию
     * @param position {@link Position}
     * @param element {@link GameElement}
     */
    void setElementAt(Position position, GameElement element);

    /**
     * Поменять два элемента местами
     * @param move {@link Move}
     */
    void swapElements(Move move);

    /**
     * Удалить элемент
     * @param position {@link Position}
     */
    void removeElementAt(Position position);

    /**
     * Метод для распечатки доски в консоль
     * @return
     */
    String toString();
}
