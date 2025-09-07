package ru.project.core_engine;

public enum GameElementBonus implements GameElement{
    ROCKET_VERTICAL(true),
    ROCKET_HORIZONTAL(true),
    BOMB(true);

    GameElementBonus(boolean isBonus) {
    }

    @Override
    public boolean isBonus() {
        return true;
    }

    @Override
    public GameElementBonus getType() {
        return this;
    }
}
