package ru.project.core_engine.impl;

import org.junit.jupiter.api.Test;
import ru.project.core_engine.ElementGenerator;
import ru.project.core_engine.GameBoard;
import ru.project.core_engine.GameElement;
import ru.project.game_logic.impl.MatchFinderImpl;
import ru.project.game_model.Position;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ElementGeneratorImplTest {

    private final ElementGenerator generator = new ElementGeneratorImpl();

    @Test
    void generate() {
        GameElement result = generator.generate();
        assertNotNull(result);
    }

    @Test
    void generateBomus() {
        GameElement result = generator.generateBonus();
        assertNotNull(result);
        assertTrue(result.isBonus());
    }

    @Test
    void initializeBoard() {
        GameBoard board = new GameBoardImpl(generator, new MatchFinderImpl());

        assertNotNull(board.getElementAt(new Position(0, 0)));
        assertNotNull(board.getElementAt(new Position(7, 7)));
    }
}