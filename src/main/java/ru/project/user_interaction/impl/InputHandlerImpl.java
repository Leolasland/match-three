package ru.project.user_interaction.impl;

import ru.project.core_engine.GameBoard;
import ru.project.game_logic.MoveValidator;
import ru.project.game_logic.impl.MoveValidatorImpl;
import ru.project.game_model.Move;
import ru.project.game_model.Position;
import ru.project.user_interaction.ErrorHandler;
import ru.project.user_interaction.InputHandler;

import java.util.Scanner;

public class InputHandlerImpl implements InputHandler {

    public static final int MAX_COORDINATE_VALUE = GameBoard.SIZE - 1;
    public static final int MIN_COORDINATE_VALUE = 0;
    private final ErrorHandler errorHandler;
    private Scanner scanner = new Scanner(System.in);
    private final MoveValidator moveValidator;

    public InputHandlerImpl() {
        this.errorHandler = new ErrorHandlerImpl();
        this.moveValidator = new MoveValidatorImpl();
    }

    @Override
    public String handle() {
        String input = scanner.nextLine().trim().replace(" ", "");

        String error = errorHandler.handleInputError(input);
        if (error != null) {
            System.out.println(error);
            return handle();
        }

        return input.toUpperCase();
    }

    @Override
    public Move parseMove(String input) {
        if (input.equalsIgnoreCase("Q")) {
            return null;
        }

        try {

            Move move = new Move(parsePosition(input.substring(0, 2).trim()),
                    parsePosition(input.substring(2, 4).trim()));
            if (!moveValidator.isValid(move)) {
                throw new IllegalArgumentException("Неверный ход! Нужно создавать комбинацию из 3+ элементов.");
            }
            return move;
        } catch (Exception e) {
            System.out.println(errorHandler.handleError(e));
            return null;
        }
    }

    private Position parsePosition(String input) {
        int row = Character.getNumericValue(input.charAt(0)) - 1;
        int column = input.charAt(1) - 'A';
        if (row < MIN_COORDINATE_VALUE || row > MAX_COORDINATE_VALUE
                || column < MIN_COORDINATE_VALUE || column > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException("Координаты должны быть валидными");
        }
        return new Position(row, column);
    }

    public void close() {
        scanner.close();
    }
}
