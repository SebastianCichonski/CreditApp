package pl.javaskils.creditapp.core;

public interface Constants {
     double MORTGAGE_LOAN_RATE = 0.2;
     double PERSONAL_LOAN_RATE = 0.1;
     String DOUBLE_REGEX = "\\d+(\\.\\d+)?";
     String INT_REGEX = "\\d+";
     String NAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]{2,10}";
     String LAST_NAME_REGEX = "([A-ZĄ-Ź][a-zą-ź]{2,12})((\\-|\\s)[A-ZĄ-Ź][a-zą-ź]{2,12})?";
     String EMAIL_REGEX = ".+\\@.+\\..+";
     String PHONE_REGEX = "(\\+\\d{2})?\\d{9}";
     String HOUSE_NUMBER_REGEX = "\\d+[A-z]?";
     String ZIP_CODE_REGEX = "\\d{2}-\\d{3}";
     String YES_NO_REGEX = "(yes|no|YES|NO)";
     String PESEL_REGEX = "\\d{11}";
     double MIN_LOAN_AMOUNT_MORTGAGE = 100000.00;

}
