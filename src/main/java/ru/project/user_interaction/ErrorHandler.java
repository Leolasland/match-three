package ru.project.user_interaction;

/**
 * Обрабатывает ошибки, преобразовывает их в корректный ответ пользователю.
 * <p>
 * Команды - выводит сообщение об ошибке в консоль
 */
public interface ErrorHandler {

    /**
     * Возвращает сообщение об ошибке
     * @param e
     */
    String handleError(Exception e);

    /**
     * Возвращает сообщение об ошибке в консоль
     * @param input
     */
    String handleInputError(String input);
}
