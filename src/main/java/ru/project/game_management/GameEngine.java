package ru.project.game_management;

import ru.project.core_engine.GameBoard;
import ru.project.game_logic.ScoreCalculationStrategy;
import ru.project.user_interaction.ConsoleRenderer;
import ru.project.user_interaction.InputHandler;

/**
 * Связывает все компоненты, управляет игровым циклом.
 * <p>
 * Команды - старт игры, игровой цикл и завершение игры.
 */
public class GameEngine {

    private final ScoreManager scoreManager;
    private final ScoreCalculationStrategy scoreCalculationStrategy;
    private final GameBoard gameBoard;
    private final InputHandler inputHandler;
    private final ConsoleRenderer consoleRenderer;

    public GameEngine() {
        this.inputHandler = new InputHandler();
        this.scoreManager = new ScoreManager();
        this.scoreCalculationStrategy = new ScoreCalculationStrategy();
        this.gameBoard = new GameBoard();
        this.consoleRenderer = new ConsoleRenderer();
    }

    /**
     * Старт игры
     */
    public void init() {

    }

    /**
     * Игровой цикл
     */
    public void gameLoop() {
        while (true) {

        }
    }

    /**
     * Корректное завершение игры
     */
    void shutdown() {

    }
}
