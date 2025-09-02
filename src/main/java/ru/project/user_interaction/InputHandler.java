package ru.project.user_interaction;

import ru.project.game_model.Move;

/**
 * Обрабатывает ввод пользователя.
 * <p>
 * Команды - обрабатывает ввод пользователя, парсит входящую строку в {@link Move} ход.
 * <p>
 * Ограничения - метод parseMove обрабатывает только валидный ввод.
 */
public interface InputHandler {


    /**
     * Обрабатывает ввод пользователя.
     * Если ввод не корректный - передает его в ErrorHandler для формирования ошибки.
     * Если ввод корректный - возвращает информацию о команде пользователя.
     */
    String handle();

    /**
     * Парсит строку в формате "БукваЦифра" (например, "A1") в объект Move.
     *
     * @return {@link Move}
     */
    Move parseMove(String input);
}
