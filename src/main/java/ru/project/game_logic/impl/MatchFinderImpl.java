package ru.project.game_logic.impl;

import ru.project.core_engine.GameBoard;
import ru.project.core_engine.GameElement;
import ru.project.game_logic.MatchFinder;
import ru.project.game_model.Match;
import ru.project.game_model.Position;

import java.util.ArrayList;
import java.util.List;

public class MatchFinderImpl implements MatchFinder {

    @Override
    public List<Match> findMatches(GameBoard board) {
        List<Match> matches = new ArrayList<>();
        findMatchesInDirection(board, matches, Direction.HORIZONTAL);
        findMatchesInDirection(board, matches, Direction.VERTICAL);
        return matches;
    }

    private void findMatchesInDirection(GameBoard board, List<Match> matches, Direction direction) {
        int size = GameBoard.SIZE;

        for (int primary = 0; primary < size; primary++) {
            int secondary = 0;

            while (secondary < size - 2) {
                int row = Direction.HORIZONTAL.equals(direction) ? primary : secondary;
                int col = Direction.HORIZONTAL.equals(direction) ? secondary : primary;

                if (isMatchStartingAt(board, row, col, direction)) {
                    List<Position> positions = getMatchPositions(board, row, col, direction);
                    matches.add(new Match(positions, board.getElementAt(new Position(row, col))));
                    secondary += positions.size(); // Пропускаем уже обработанные элементы
                } else {
                    secondary++;
                }
            }
        }
    }

    private boolean isMatchStartingAt(GameBoard board, int startRow, int startCol, Direction direction) {
        GameElement firstElement = board.getElementAt(new Position(startRow, startCol));
        if (firstElement == null) {
            return false;
        }

        int rowStep = direction.rowStep;
        int colStep = direction.colStep;

        // Проверяем следующие два элемента
        for (int i = 1; i < 3; i++) {
            int row = startRow + i * rowStep;
            int col = startCol + i * colStep;

            GameElement element = board.getElementAt(new Position(row, col));
            if ((!isValidPosition(row, col) ||
                    element == null) ||
                    element.getType() != firstElement.getType()) {
                return false;
            }
        }

        return true;
    }

    private List<Position> getMatchPositions(GameBoard board, int startRow, int startCol, Direction direction) {
        List<Position> positions = new ArrayList<>();
        GameElement firstElement = board.getElementAt(new Position(startRow, startCol));

        int rowStep = direction.rowStep;
        int colStep = direction.colStep;

        int currentRow = startRow;
        int currentCol = startCol;

        GameElement currentElement = board.getElementAt(new Position(currentRow, currentCol));
        // Добавляем все последовательные элементы того же типа
        while (isValidPosition(currentRow, currentCol) &&
                currentElement != null &&
                (currentElement.getType() == firstElement.getType()
                        || currentElement.getType().isBonus())) {

            positions.add(new Position(currentRow, currentCol));
            currentRow += rowStep;
            currentCol += colStep;
            currentElement = board.getElementAt(new Position(currentRow, currentCol));
        }

        return positions;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < GameBoard.SIZE && col >= 0 && col < GameBoard.SIZE;
    }

    // Внутренний enum для направления поиска
    private enum Direction {
        HORIZONTAL(0, 1),
        VERTICAL(1, 0);

        final int rowStep;
        final int colStep;

        Direction(int rowStep, int colStep) {
            this.rowStep = rowStep;
            this.colStep = colStep;
        }
    }
}
