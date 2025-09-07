package ru.project.user_interaction;

import ru.project.core_engine.GameBoard;

/**
 * Отображает игру в консоль.
 * <p>
 * Команды - отображение игры в консоль, вывод стартовой информации.
 */
public interface ConsoleRenderer {

    /**
     * Отображение игры в консоль
     * @param gameBoard {@link GameBoard} игровая доска
     */
    void render(GameBoard gameBoard);

    /**
     * Вывод стартовой информации.
     */
    void startRender();
}
