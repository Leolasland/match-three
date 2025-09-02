package ru.project.user_interaction;

import ru.project.core_engine.GameBoard;

/**
 * Отображает игру в консоль.
 * <p>
 * Команды - отображение игры в консоль.
 */
public interface ConsoleRenderer {

    /**
     * Отображение игры в консоль
     */
    void render(GameBoard gameBoard);
}
