package ru.project.core_engine;

import ru.project.game_model.Position;

/**
 * Генерирует элементы.
 * <p>
 * Запросы - генерация элемента.
 * <p>
 * Команды - отсутствуют.
 */
public interface ElementGenerator {

    /**
     * Заполняет недостающие элементы доски для {@link Position}.
     *
     * @param position {@link Position}.
     * @return матрица {@link GameElement}
     */
    GameElement generate(Position position);

    /**
     * Инициализация доски происходит без бонусных элементов.
     * @param gameBoard {@link GameBoard}.
     */
    void initializeBoard(GameBoard gameBoard);
}