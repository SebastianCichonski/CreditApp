package pl.javaskils.creditapp.core.exception;

public class RegexException extends ValidationException{
    public RegexException(String field) {
        super(String.format("Field %s does match regex.", field));
    }
}
