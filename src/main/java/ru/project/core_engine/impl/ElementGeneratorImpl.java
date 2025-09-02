package ru.project.core_engine.impl;

import ru.project.core_engine.ElementGenerator;
import ru.project.core_engine.GameBoard;
import ru.project.core_engine.GameElement;
import ru.project.game_model.Position;

import java.util.Random;

public class ElementGeneratorImpl implements ElementGenerator {

    private final Random random = new Random();

    @Override
    public GameElement generate(Position position) {
        return null;
    }

    @Override
    public void initializeBoard(GameBoard gameBoard) {

    }
}
