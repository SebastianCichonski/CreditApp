package pl.javaskils.creditapp.core;

public class Constants {
    public static final double MORTGAGE_LOAN_RATE = 0.2;
    public static final double PERSONAL_LOAN_RATE = 0.1;
    public static final String DOUBLE_REGEX = "\\d+(\\.\\d+)?";
    public static final String INT_REGEX = "\\d+";
    public static final String NAME_REGEX = "[A-ZĄ-Ź][a-zą-ź]{2,10}";
    public static final String LAST_NAME_REGEX = "([A-ZĄ-Ź][a-zą-ź]{2,12})((\\-|\\s)[A-ZĄ-Ź][a-zą-ź]{2,12})?";
    public static final String EMAIL_REGEX = ".+\\@.+\\..+";
    public static final String PHONE_REGEX = "(\\+\\d{2})?\\d{9}";
    public static final double MIN_LOAN_AMOUNT_MORTGAGE = 100000.00;
}
