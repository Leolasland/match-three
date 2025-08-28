package ru.project.core_engine;

import ru.project.game_model.Position;

/**
 * Генерирует элементы.
 * <p>
 * Запросы - генерация элемента.
 * <p>
 * Команды - отсутствуют.
 */
public class ElementGenerator {

    /**
     * Заполняет недостающие элементы доски для {@link Position}.
     *
     * @param position {@link Position}.
     * @return матрица {@link GameElement}
     */
    public GameElement generate(Position position) {
        return null;
    }

    /**
     * Инициализация доски происходит без бонусных элементов.
     * @param gameBoard {@link GameBoard}.
     */
    public void initializeBoard(GameBoard gameBoard) {

    }
}