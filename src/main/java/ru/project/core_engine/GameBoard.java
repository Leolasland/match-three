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
public class GameBoard {

    private final ElementGenerator elementGenerator;
    private final GameElement[][] board;
    public static final int SIZE = 7;

    public GameBoard() {
        this.elementGenerator = new ElementGenerator();
        this.board = null;
        this.elementGenerator.initializeBoard(this);
    }

    /**
     * Возвращает текущее состояние доски
     * @return
     */
    public GameBoard getBoard() {

    }

    /**
     * Является ли клетка на позиции {@link Position} пустой
     * @return true или false
     */
    public boolean isEmpty(Position position) {

    }

    /**
     * Установка элемент на позицию
     * @param position {@link Position}
     * @param element {@link GameElement}
     */
    public void setElementAt(Position position, GameElement element) {

    }

    /**
     * Поменять два элемента местами
     * @param move {@link Move}
     */
    public void swapElements(Move move) {

    }

    /**
     * Удалить элемент
     * @param position {@link Position}
     */
    public void removeElementAt(Position position) {

    }
}
