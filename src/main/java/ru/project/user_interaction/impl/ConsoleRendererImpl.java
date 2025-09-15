package ru.project.user_interaction.impl;

import ru.project.core_engine.GameBoard;
import ru.project.core_engine.GameElement;
import ru.project.game_model.Position;
import ru.project.user_interaction.ConsoleRenderer;

import static java.lang.System.out;
import static ru.project.core_engine.GameBoard.SIZE;
import static ru.project.core_engine.GameElementBonus.*;
import static ru.project.core_engine.GameElementDefault.*;

public class ConsoleRendererImpl implements ConsoleRenderer {


    @Override
    public void render(GameBoard gameBoard) {
        clearScreen();
        out.println();
        out.println("  A  B   C  D  E   F  G  H");
        out.println("  — — — — — — — — — — — — — —");
        for (int row = 0; row < SIZE; row++) {
            out.print((row + 1) + "|");
            for (int column = 0; column < SIZE; column++) {
                GameElement element = gameBoard.getElementAt(new Position(row, column));
                if (element != null) {
                    out.print(elementForPrint(element) + " ");
                } else {
                    out.print("  ");
                }
            }
            out.println("|" + (row + 1));
        }
        out.println("  — — — — — — — — — — — — — —");
        out.println("  A  B   C  D  E   F  G  H");
    }

    @Override
    public void startRender() {
        out.println("Добро пожаловать в игру 'Три в ряд'!");
        out.println("Для хода введите координаты в формате: row1column1row2column2");
        out.println("Например: 1A2A для перемещения из (1,A) в (2,А)");
        out.println("Для выхода введите: q");
    }


    private static void clearScreen() {
        try {
            out.print("\033[H\033[2J");
            out.flush();
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                out.println();
            }
        }
    }

    private String elementForPrint(GameElement element) {
        return switch (element) {
            case BOMB -> "💣";
            case ROCKET_HORIZONTAL -> "↔️";
            case ROCKET_VERTICAL -> "↕️";
            case A -> "🟥";
            case B -> "🟨";
            case C -> "🟩";
            case D -> "🟦";
            case E -> "🟪";
            default -> "❓";
        };
    }
}
