package pl.javaskils.creditapp.core.exception;

public class MinValueException extends ValidationException{
    public MinValueException(String field, int extMinValue) {
        super(String.format("Field %s does match regex. Min value = %s", field, extMinValue));
    }

    public MinValueException(String field, double extMinValue) {
        super(String.format("Field %s does match regex. Min value = %s", field, extMinValue));
    }

    public MinValueException(String field, byte extMinValue) {
        super(String.format("Field %s does match regex. Min value = %s", field, extMinValue));
    }
}
