package ru.project.game_model;

import ru.project.core_engine.GameElement;

import java.util.Set;

/**
 * Класс предоставляющий комбинацию из трех и более одинаковых элементов.
 * <p>
 * Запросы - получить набор {@link Position} позиций и элемент {@link GameElement}.
 * <p>
 * Команды - отсутствуют, так как класс неизменяемый.
 * <p>
 * Ограничения:
 * <li> Набор позиций не может быть null или пустым.
 * <li> Элемент не может быть пустым.
 */
public record Match(Set<Position> positions, GameElement gameElement) {

    /**
     * Создаем комбинацию
     * @param positions {@link Position} набор позиций
     * @param gameElement {@link GameElement} элемент
     */
    public Match {
        if (positions == null || gameElement == null) {
            throw new IllegalArgumentException();
        }
    }
}
