package ru.project.game_management;

import ru.project.core_engine.GameBoard;
import ru.project.core_engine.impl.ElementGeneratorImpl;
import ru.project.core_engine.impl.GameBoardImpl;
import ru.project.game_logic.MatchFinder;
import ru.project.game_logic.impl.MatchFinderImpl;
import ru.project.game_management.impl.ScoreManagerImpl;
import ru.project.game_model.Match;
import ru.project.game_model.Move;
import ru.project.user_interaction.ConsoleRenderer;
import ru.project.user_interaction.InputHandler;
import ru.project.user_interaction.impl.ConsoleRendererImpl;
import ru.project.user_interaction.impl.InputHandlerImpl;

import java.util.List;

/**
 * Связывает все компоненты, управляет игровым циклом.
 * <p>
 * Команды - старт игры, игровой цикл и завершение игры.
 */
public class GameEngine {

    private final ScoreManager scoreManager;
    private final GameBoard gameBoard;
    private final InputHandler inputHandler;
    private final ConsoleRenderer consoleRenderer;
    private final MatchFinder matchFinder;

    public GameEngine() {
        this.inputHandler = new InputHandlerImpl();
        this.scoreManager = new ScoreManagerImpl();
        this.matchFinder = new MatchFinderImpl();
        this.gameBoard = new GameBoardImpl(new ElementGeneratorImpl(), this.matchFinder);
        this.consoleRenderer = new ConsoleRendererImpl();
    }

    /**
     * Старт игры
     */
    public void startGame() {
        consoleRenderer.startRender();
        consoleRenderer.render(gameBoard);
        gameLoop();
    }

    /**
     * Игровой цикл
     */
    public void gameLoop() {
        while (true) {
            String input = inputHandler.handle();
            if (input.equalsIgnoreCase("Q")) {
                shutdown();
                break;
            }
            Move move = inputHandler.parseMove(input);
            if (move == null) {
                continue;
            }
            gameBoard.swapElements(move);
            List<Match> matches = matchFinder.findMatches(gameBoard);
            if (matches.isEmpty()) { // Если нет совпадений, возвращаем элементы на место
                gameBoard.swapElements(move);
                System.out.println("Нет совпадений! Попробуйте другой ход.");
                continue;
            }
            scoreManager.recordMove(move, matches);
            gameBoard.processMatches(matches);
            consoleRenderer.render(gameBoard);
        }
    }

    /**
     * Корректное завершение игры
     */
    void shutdown() {
        System.out.println("\nИгра окончена!");
        System.out.println("Финальный счет: " + scoreManager.getScore());
        System.out.println("История ходов: ");
        scoreManager.getHistoryOfMoves()
                .forEach(System.out::println);
        inputHandler.close();
    }
}
