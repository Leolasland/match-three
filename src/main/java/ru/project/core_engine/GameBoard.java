package ru.project.core_engine;

import ru.project.game_model.Match;
import ru.project.game_model.Move;
import ru.project.game_model.Position;

import java.util.List;

/**
 * Игровое поле, хранит и обновляет состояние
 * Размер игрового поля - 8 элементов.
 * <p>
 * Запросы - получить текущее состояние доски и проверить является ли клетка на позиции пустой, получить элемент на позиции.
 * <p>
 * Команды - поменять элементы местами и установка, удаление элемента на позиции.
 * <p>
 * Ограничения - запросы и команды обращающиеся за пределы игрового поля невозможны.
 */
public interface GameBoard {

    int SIZE = 8;

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

    void processMatches(List<Match> matches);

    /**
     * Получить элемент на позиции
     * @param position {@link Position} позиция, не может быть пустым
     * @return {@link GameElement} элемент
     */
    GameElement getElementAt(Position position);

    /**
     * Метод для получения доски
     * @return
     */
    GameElement[][] getBoardElements();

    List<Match> checkForMatches();
}
