package ru.project.core_engine;

/**
 * Генерирует элементы.
 * <p>
 * Запросы - генерация элемента.
 * <p>
 * Команды - инициализация доски.
 */
public interface ElementGenerator {

    /**
     * Генерирует элемент
     *
     * @return элемент {@link GameElement}
     */
    GameElement generate();

    /**
     * Генерирует бонусный элемент
     * @return элемент {@link GameElement}
     */
    GameElement generateBonus();

    /**
     * Инициализация доски происходит без бонусных элементов.
     * Доска первоначально заполняется элементами которые гарантировано не создают комбинаций.
     * @param gameBoard {@link GameBoard}.
     */
    void initializeBoard(GameBoard gameBoard);
}