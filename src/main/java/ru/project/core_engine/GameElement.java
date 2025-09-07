package ru.project.core_engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Элемент (A, B, C, D, E) - не может быть бонусным.
 * Элемент (ROCKET, BOMB) - бонусный.
 * <p>
 * Запросы - узнать является ли элемент бонусным, получить все не бонусные элементы, или все бонусные, получить тип элемента.
 * <p>
 * Команды - отсутствуют, так как класс неизменяемый.
 */
public interface GameElement<T extends GameElement> {


    boolean isBonus();

    T getType();

    static List<GameElement> getAllGameElements() {
        List<GameElement> allElements = new ArrayList<>();

        allElements.addAll(getAllBonusGameElements());
        allElements.addAll(getAllDefaulGameElements());
        return allElements;
    }

    static List<GameElement> getAllBonusGameElements() {
        return Arrays.asList(GameElementBonus.values());
    }

    static List<GameElement> getAllDefaulGameElements() {
        return Arrays.asList(GameElementDefault.values());
    }
}
