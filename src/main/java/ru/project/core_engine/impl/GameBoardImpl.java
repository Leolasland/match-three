package ru.project.core_engine.impl;

import ru.project.core_engine.ElementGenerator;
import ru.project.core_engine.GameBoard;
import ru.project.core_engine.GameElement;
import ru.project.game_logic.MatchFinder;
import ru.project.game_model.Match;
import ru.project.game_model.Move;
import ru.project.game_model.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static ru.project.core_engine.GameElementBonus.*;

public class GameBoardImpl implements GameBoard {
    private final ElementGenerator elementGenerator;
    private final MatchFinder matchFinder;
    private final GameElement[][] board;

    public GameBoardImpl(ElementGenerator elementGenerator, MatchFinder matchFinder) {
        this.board = new GameElement[GameBoard.SIZE][GameBoard.SIZE];
        this.elementGenerator = elementGenerator;
        elementGenerator.initializeBoard(this);
        this.matchFinder = matchFinder;
    }

    @Override
    public void setElementAt(Position position, GameElement element) {
        if (position == null || element == null) {
            throw new IllegalArgumentException("Position or GameElement cannot be null");
        }
        board[position.row()][position.column()] = element;
    }

    @Override
    public void swapElements(Move move) {
        GameElement temp = getElementAt(move.from());
        setElementAt(move.from(), getElementAt(move.to()));
        setElementAt(move.to(), temp);
    }

    @Override
    public void removeElementAt(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        board[position.row()][position.column()] = null;
    }

    @Override
    public void processMatches(List<Match> matches) {
        Set<Position> bonusPositions = new HashSet<>();

        for (Match match : matches) {
            if (match.positions().size() > 4) { // Создаем бонусный элемент в центре совпадения
                Position center = findCenter(match.positions());
                bonusPositions.add(center);

                GameElement newBonusElement = elementGenerator.generateBonus();
                this.setElementAt(center, newBonusElement);
            }
        }

        this.removeMatches(matches);

        for (Position pos : bonusPositions) { // Применяем эффекты бонусных элементов
            GameElement element = this.getElementAt(pos);
            if (element != null && element.isBonus()) {
                this.applyBonusEffects(pos, element.getType());
            }
        }

        // Заполняем доску
        this.refillBoard();

        // Проверяем каскадные совпадения
        List<Match> cascadeMatches = this.checkForMatches();
        if (!cascadeMatches.isEmpty()) {
            processMatches(cascadeMatches);
        }
    }

    public void removeMatches(List<Match> matches) {
        Set<Position> positionsToRemove = matches.stream()
                .flatMap(match -> match.positions().stream())
                .collect(Collectors.toSet());

        for (Position pos : positionsToRemove) {
            removeElementAt(pos);
        }
    }

    private Position findCenter(List<Position> positions) {
        int sumRow = 0;
        int sumCol = 0;
        for (Position pos : positions) {
            sumRow += pos.row();
            sumCol += pos.column();
        }
        return new Position(sumRow / positions.size(), sumCol / positions.size());
    }

    @Override
    public GameElement getElementAt(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }
        return board[position.row()][position.column()];
    }

    @Override
    public List<Match> checkForMatches() {
        return matchFinder.findMatches(this);
    }

    public void refillBoard() {
        for (int col = 0; col < GameBoard.SIZE; col++) { // Падение элементов вниз
            for (int row = GameBoard.SIZE - 1; row >= 0; row--) {
                if (getElementAt(new Position(row, col)) == null) {
                    for (int aboveRow = row - 1; aboveRow >= 0; aboveRow--) {
                        GameElement element = getElementAt(new Position(aboveRow, col));
                        if (element != null) {
                            setElementAt(new Position(row, col), element);
                            removeElementAt(new Position(aboveRow, col));
                            break;
                        }
                    }
                }
            }
        }

        for (int row = 0; row < GameBoard.SIZE; row++) { // Заполнение пустых ячеек новыми элементами
            for (int col = 0; col < GameBoard.SIZE; col++) {
                if (getElementAt(new Position(row, col)) == null) {
                    setElementAt(new Position(row, col), elementGenerator.generate());
                }
            }
        }
    }

    public void applyBonusEffects(Position position, GameElement bonusType) {
        switch (bonusType) {
            case ROCKET_HORIZONTAL -> removeRow(position.row());
            case ROCKET_VERTICAL -> removeColumn(position.column());
            case BOMB -> remove3x3Area(position);
            default -> throw new IllegalStateException("Unexpected value: " + bonusType);
        }
    }

    private void removeRow(int row) {
        for (int col = 0; col < GameBoard.SIZE; col++) {
            removeElementAt(new Position(row, col));
        }
    }

    private void removeColumn(int col) {
        for (int row = 0; row < GameBoard.SIZE; row++) {
            removeElementAt(new Position(row, col));
        }
    }

    private void remove3x3Area(Position center) {
        for (int row = Math.max(0, center.row() - 1); row <= Math.min(GameBoard.SIZE - 1, center.row() + 1); row++) {
            for (int col = Math.max(0, center.column() - 1); col <= Math.min(GameBoard.SIZE - 1, center.column() + 1); col++) {
                removeElementAt(new Position(row, col));
            }
        }
    }
}
