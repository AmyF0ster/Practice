package io.foster.awesomeapp;

public class NotFoundException extends RuntimeException{
    private Integer resourceId;
    private String resourceType;
    public NotFoundException(Integer resourceId, String resourceType){
        super(resourceType + " с id " + resourceId + " не найден(а)");
    }
}
