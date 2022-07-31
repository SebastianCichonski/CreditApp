package pl.javaskils.creditapp.core.exception;

public class MaxValueException extends ValidationException{
    public MaxValueException(String field, int extMaxValue) {
        super(String.format("Field %s does match regex. Max value = %s", field, extMaxValue));
    }

    public MaxValueException(String field, double extMaxValue) {
        super(String.format("Field %s does match regex. Max value = %s", field, extMaxValue));
    }

    public MaxValueException(String field, byte extMaxValue) {
        super(String.format("Field %s does match regex. Max value = %s", field, extMaxValue));
    }
}
