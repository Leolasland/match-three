package ru.project.game_management;

import ru.project.core_engine.GameBoard;
import ru.project.core_engine.impl.ElementGeneratorImpl;
import ru.project.core_engine.impl.GameBoardImpl;
import ru.project.game_logic.MatchFinder;
import ru.project.game_logic.ScoreCalculationStrategy;
import ru.project.game_logic.impl.MatchFinderImpl;
import ru.project.game_logic.impl.ScoreCalculationStrategyImpl;
import ru.project.game_management.impl.ScoreManagerImpl;
import ru.project.user_interaction.ConsoleRenderer;
import ru.project.user_interaction.InputHandler;
import ru.project.user_interaction.impl.ConsoleRendererImpl;
import ru.project.user_interaction.impl.InputHandlerImpl;

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
    private final MatchFinder matchFinder;

    public GameEngine() {
        this.inputHandler = new InputHandlerImpl();
        this.scoreManager = new ScoreManagerImpl();
        this.scoreCalculationStrategy = new ScoreCalculationStrategyImpl();
        this.gameBoard = new GameBoardImpl(new ElementGeneratorImpl());
        this.consoleRenderer = new ConsoleRendererImpl();
        this.matchFinder = new MatchFinderImpl();
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
            GameBoard board = gameBoard.getBoard();
            consoleRenderer.render(board);
            inputHandler.handle();
        }
    }

    /**
     * Корректное завершение игры
     */
    void shutdown() {

    }
}
