package pl.javaskils.creditapp.client;

import pl.javaskils.creditapp.core.Constants;

public class PhoneValidator {
    public static boolean validate(String input){
        if(input.matches(Constants.PHONE_REGEX)) return true;
        else return false;
    }
}
