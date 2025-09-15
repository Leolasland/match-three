package ru.project.game_logic.impl;

import ru.project.game_logic.MoveValidator;
import ru.project.game_model.Move;
import ru.project.game_model.Position;

public class MoveValidatorImpl implements MoveValidator {
    @Override
    public boolean isValid(Move move) {
        Position from = move.from();
        Position to = move.to();

        int rowDiff = Math.abs(from.row() - to.row());
        int colDiff = Math.abs(from.column() - to.column());

        return (rowDiff == 1 && colDiff == 0) || (rowDiff == 0 && colDiff == 1);
    }
}
