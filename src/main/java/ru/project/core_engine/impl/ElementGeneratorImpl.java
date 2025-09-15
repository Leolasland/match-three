package ru.project.core_engine.impl;

import ru.project.core_engine.ElementGenerator;
import ru.project.core_engine.GameBoard;
import ru.project.core_engine.GameElement;
import ru.project.game_model.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ElementGeneratorImpl implements ElementGenerator {

    private final Random random = new Random();

    @Override
    public GameElement generate() {
        GameElement element = generateElementFromList(GameElement.getAllGameElements());
        return element;
    }

    @Override
    public GameElement generateBonus() {
        GameElement element = generateElementFromList(GameElement.getAllBonusGameElements());
        return element;
    }

    @Override
    public void initializeBoard(GameBoard gameBoard) {
        for (int row = 0; row < GameBoard.SIZE; row++) {
            for (int column = 0; column < GameBoard.SIZE; column++) {
                Position position = new Position(row, column);
                GameElement element = generateSafe(gameBoard, position);
                gameBoard.setElementAt(position, element);
            }
        }
    }

    private GameElement generateSafe(GameBoard gameBoard, Position position) {
        Set<GameElement> forbiddenElements = getExistingTypes(gameBoard, position);
        List<GameElement> defaultElements = GameElement.getAllDefaulGameElements().stream()
                .filter(gameElement -> !forbiddenElements.contains(gameElement))
                .toList();

        return generateElementFromList(defaultElements);
    }

    private GameElement generateElementFromList(List<GameElement> elements) {
        return elements.get(random.nextInt(elements.size()));
    }


    private Set<GameElement> getExistingTypes(GameBoard gameBoard, Position position) {
        Set<GameElement> forbidden = new HashSet<>();

        if (position.column() >= 2) {
            Position left1 = new Position(position.row(), position.column() - 1);
            Position left2 = new Position(position.row(), position.column() - 2);
            if (areElementsEqual(gameBoard, left1, left2)) {
                forbidden.add(gameBoard.getElementAt(left1));
            }
        }

        if (position.row() >= 2) {
            Position up1 = new Position(position.row() - 1, position.column());
            Position up2 = new Position(position.row() - 2, position.column());
            if (areElementsEqual(gameBoard, up1, up2)) {
                forbidden.add(gameBoard.getElementAt(up1));
            }
        }

        return forbidden;
    }

    private boolean areElementsEqual(GameBoard board, Position pos1, Position pos2) {
        GameElement elem1 = board.getElementAt(pos1);
        GameElement elem2 = board.getElementAt(pos2);
        return elem1 != null && elem1.equals(elem2);
    }
}
