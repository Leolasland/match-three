package ru.project.user_interaction.impl;

import ru.project.game_model.Move;
import ru.project.user_interaction.ErrorHandler;
import ru.project.user_interaction.InputHandler;

import java.util.Scanner;

public class InputHandlerImpl implements InputHandler {

    private ErrorHandler errorHandler;
    private Scanner scanner = new Scanner(System.in);

    public InputHandlerImpl() {
        this.errorHandler = new ErrorHandlerImpl();
    }

    @Override
    public String handle() {
        return "";
    }

    @Override
    public Move parseMove(String input) {
        return null;
    }
}
