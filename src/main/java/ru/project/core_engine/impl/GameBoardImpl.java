package ru.project.core_engine.impl;

import ru.project.core_engine.ElementGenerator;
import ru.project.core_engine.GameBoard;
import ru.project.core_engine.GameElement;
import ru.project.game_model.Move;
import ru.project.game_model.Position;

import java.util.Arrays;

public class GameBoardImpl implements GameBoard {
    private final ElementGenerator elementGenerator;
    private final GameElement[][] board;

    public GameBoardImpl(ElementGenerator elementGenerator) {
        this.elementGenerator = elementGenerator;
        this.board = null;
        this.elementGenerator.initializeBoard(this);
    }

    @Override
    public GameBoard getBoard() {
        return null;
    }

    @Override
    public boolean isEmpty(Position position) {
        return false;
    }

    @Override
    public void setElementAt(Position position, GameElement element) {

    }

    @Override
    public void swapElements(Move move) {

    }

    @Override
    public void removeElementAt(Position position) {

    }

    @Override
    public String toString() {
        return "";
    }
}
