package pl.javaskils.creditapp.core.validation;

import pl.javaskils.creditapp.core.exception.*;

import java.lang.reflect.Field;

public class ValidationUtils {
    public static void validateNotNull(String field, Object object) throws ValidationException{
        if(object == null){
            throw new NotNullException(field);
        }
    }

    public static void validatePesel(String field, String pesel, String regex)throws RegexException{
        if(!pesel.matches(regex)){
            throw new RegexException(field);
        }
    }

    public static void validateRegex(String field, String value, String regex) throws RegexException{
        if(!value.matches(regex)){
            throw new RegexException(field);
        }
    }

    public static void validateMinValue(String field, int extMinValue, int actualMinValue) throws MinValueException {
        if(actualMinValue <= extMinValue){
            throw new MinValueException(field, extMinValue);
        }
    }

    public static void validateMinValue(String field, double extMinValue, double actualMinValue) throws MinValueException {
        if(actualMinValue <= extMinValue){
            throw new MinValueException(field, extMinValue);
        }
    }

    public static void validateMinValue(String field, byte extMinValue, byte actualMinValue) throws MinValueException {
        if(actualMinValue <= extMinValue){
            throw new MinValueException(field, extMinValue);
        }
    }

    public static void validateMaxValue(String field, int extMaxValue, int actualMaxValue) throws MaxValueException {
        if(actualMaxValue >= extMaxValue){
            throw new MaxValueException(field, extMaxValue);
        }
    }

    public static void validateMaxValue(String field, double extMaxValue, double actualMaxValue) throws MaxValueException {
        if(actualMaxValue >= extMaxValue){
            throw new MaxValueException(field, extMaxValue);
        }
    }

    public static void validateMaxValue(String field, byte extMaxValue, byte actualMaxValue) throws MaxValueException {
        if(actualMaxValue >= extMaxValue){
            throw new MaxValueException(field, extMaxValue);
        }
    }

}
