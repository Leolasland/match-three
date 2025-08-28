package ru.project.core_engine;

/**
 * Элемент (A, B, C, D, E), может быть бонусным.
 * <p>
 * Запросы - узнать является ли элемент бонусным.
 * <p>
 * Команды - отсутствуют, так как класс неизменяемый.
 */
public enum GameElement {
    A(false),
    B(false),
    C(false),
    D(false),
    E(false),
    ROCKET(true),
    BOMB(true);

    private final boolean isBonus;

    GameElement(boolean isBonus) {
        this.isBonus = isBonus;
    }

    boolean isBonus() {
        return isBonus;
    }


}
