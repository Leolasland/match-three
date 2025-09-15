package ru.project.user_interaction.impl;

import ru.project.user_interaction.ErrorHandler;

public class ErrorHandlerImpl implements ErrorHandler {
    @Override
    public String handleError(Exception e) {
        if (e instanceof NumberFormatException) {
            return "Ошибка: введите корректные значения для координат";
        } else if (e instanceof ArrayIndexOutOfBoundsException) {
            return "Ошибка: координаты должны быть от 1 до 8 или от A до H";
        } else if (e instanceof IllegalArgumentException) {
            return e.getMessage();
        }
        return "Произошла непредвиденная ошибка: " + e.getMessage();
    }

    public String handleInputError(String input) {
        if (input.length() != 4 && !input.equalsIgnoreCase("q")) {
            return "Ошибка: введите координаты для перемещения (например: 1A 1B) или q для выхода";
        }
        return null;
    }
}
