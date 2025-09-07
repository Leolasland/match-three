package ru.project.core_engine;

public enum GameElementDefault implements GameElement {
    A(false),
    B(false),
    C(false),
    D(false),
    E(false);

    private final boolean isBonus;

    GameElementDefault(boolean isBonus) {
        this.isBonus = isBonus;
    }

    @Override
    public boolean isBonus() {
        return false;
    }

    @Override
    public GameElementDefault getType() {
        return this;
    }
}
