package pl.javaskils.creditapp.core.exception;

public class NotNullException extends ValidationException{
    public NotNullException(String field) {
        super(String.format("Field %s should by not null.", field));
    }
}
