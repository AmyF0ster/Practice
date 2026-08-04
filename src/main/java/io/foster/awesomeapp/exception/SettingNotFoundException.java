package io.foster.awesomeapp.exception;

public class SettingNotFoundException extends RuntimeException {
    public SettingNotFoundException(String message) {
        super(message);
    }
}
