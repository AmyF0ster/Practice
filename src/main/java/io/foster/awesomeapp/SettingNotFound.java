package io.foster.awesomeapp;

public class SettingNotFound extends RuntimeException {
    private String resourceName;
    public SettingNotFound(String resourceName){
        super("Настройка " + resourceName + " не найдена");
    }
}
