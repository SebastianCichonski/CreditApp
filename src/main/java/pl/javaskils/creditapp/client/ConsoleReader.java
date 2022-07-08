package pl.javaskils.creditapp.client;

import pl.javaskils.creditapp.core.Constants;
import pl.javaskils.creditapp.core.model.*;
import java.util.Scanner;

public class ConsoleReader {


    public LoanApplication readInputParameters() {
        Scanner in = new Scanner(System.in);

        String name = getString("Enter your name: ", in, Constants.NAME_REGEX);;

        String lastName = getString("Enter your last name: ", in, Constants.LAST_NAME_REGEX);

        String mothersMaidenName = getString("Enter your mother's maiden name: ", in, Constants.LAST_NAME_REGEX);

        String street = getString("Enter address - street: ", in, Constants.LAST_NAME_REGEX);
        String city = getString("Enter address - city: ", in, Constants.LAST_NAME_REGEX);
        String houseNumber = getString("Enter address - house number: ", in, Constants.HOUSE_NUMBER_REGEX);
        String zipCode = getString("Enter address - zip code: ", in, Constants.ZIP_CODE_REGEX);
        String state = getString("Enter address - state: ", in, Constants.LAST_NAME_REGEX);

        //TODO read correspondence address

        MartialStatus martialStatus = getMartialStatus(in);

        Education education = getEducation(in);

        String email = getString("Enter your email address: ", in, Constants.EMAIL_REGEX);

        String phoneNumber = getString("Enter your phone number: ", in, Constants.PHONE_REGEX);


        SourceOfIncome[] sourceOfIncomesTab = getSourceOfIncomes(in);

        int numOfFamilyDependants = getInt("Enter number of family dependants (including applicant): ", in);


        PurposeOfLoanType purposeOfLoanType = getPurposeOfLoanType(in);

        double amount = getDouble(in);

        byte period = getPeriod(in);

        Address homeAddress = new Address(street,city,houseNumber,zipCode,state);

        PersonalData pd = PersonalData.Builder
                .create()
                .withName(name)
                .withLastName(lastName)
                .withMothersMaidenName(mothersMaidenName)
                .withNumOfFamilyDependants(numOfFamilyDependants)
                .withEducation(education)
                .withMartialStatus(martialStatus)
                .build();

        ContactData cd = ContactData.Builder.create()
                .withEmail(email)
                .withPhoneNumber(phoneNumber)
                .withHomeAddress(homeAddress)
                .withCorrespondenceAddress(correspondenceAddress)
                .build();

        FinanceData fd = new FinanceData(sourceOfIncomesTab);

        Person person =  Person.Builder.create().withPersonalData(pd).withContactData(cd).withFinanceData(fd).build();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(purposeOfLoanType, amount, period);

        return new LoanApplication(person, purposeOfLoan);
    }

    private byte getPeriod(Scanner in) {
        String periodString;
        do {
            System.out.println("Enter loan period (in years): ");
            periodString = in.next();
        }while(!NumberValidator.validateInteger(periodString, 5,10,15,20,25,30));
        byte period = Byte.parseByte(periodString);
        return period;
    }

    private PurposeOfLoanType getPurposeOfLoanType(Scanner in) {
        String purposeOfLoanTypeInput;
        do {
            System.out.println("What is purpose of loan? (MORTGAGE | PERSONAL_LOAN)");
            purposeOfLoanTypeInput = in.next().toUpperCase();
        }while(!EnumValidator.validatePurposeOfLoanType(purposeOfLoanTypeInput));
        PurposeOfLoanType purposeOfLoanType = PurposeOfLoanType.valueOf(purposeOfLoanTypeInput);
        return purposeOfLoanType;
    }

    private double getDouble(Scanner in) {
        String amountString;
        do {
            System.out.println("Enter loan amount?: ");
            amountString = in.next();
        }while(!NumberValidator.validateDouble(amountString, 0.0, Double.MAX_VALUE));
        double amount = Double.parseDouble(amountString);
        return amount;
    }

    private int getInt(String x, Scanner in) {
        String string;
        do {
            System.out.println(x);
            string = in.next();
        }while (!NumberValidator.validateInteger(string,1, Integer.MAX_VALUE));
        int number = Integer.parseInt(string);
        return number;
    }

    private MartialStatus getMartialStatus(Scanner in) {
        String martialStatusElement = "( ";
        for(int i =0; i<MartialStatus.values().length; i++){
            martialStatusElement += MartialStatus.values()[i].name();
            if(i<MartialStatus.values().length-1){
                martialStatusElement += ", ";
            }
        }
        martialStatusElement += " )";

        String martialStatusInput;
        do {
            System.out.println("What is your martial status? " + martialStatusElement);
            martialStatusInput = in.next().toUpperCase();
        } while (!EnumValidator.validateMartialStatus(martialStatusInput));
        MartialStatus martialStatus = MartialStatus.valueOf(martialStatusInput);
        return martialStatus;
    }

    private Education getEducation(Scanner in) {
        String educationInput;
        do {
            System.out.println("What is your education level? (NONE, PRIMARY, MIDDLE, SECONDARY, POST_SECONDARY, TERTIARY): ");
            educationInput = in.next().toUpperCase();
        }while (!EnumValidator.validateEducation(educationInput));
        Education education= Education.valueOf(educationInput);
        return education;
    }

    private SourceOfIncome[] getSourceOfIncomes(Scanner in) {
        int sources = getInt("How many sources of income do you have? ", in);

        SourceOfIncome[] sourceOfIncomesTab = new SourceOfIncome[sources];

        for (int i = 1; i <= sources; i++) {

            String incomeTypeInput;
            do {
                System.out.println("Enter type of source of income " + i + " (EMPLOYMENT_CONTRACT | SELF_EMPLOYMENT | RETIREMENT): ");
                incomeTypeInput = in.next().toUpperCase();
            }while (!EnumValidator.validateIncomeType(incomeTypeInput));
            IncomeType incomeType = IncomeType.valueOf(incomeTypeInput);

            System.out.println("Enter net monthly income of source of income " + i + ": ");
            double monthlyIncomeOfSource = Double.parseDouble(in.next());

            sourceOfIncomesTab[i - 1] = new SourceOfIncome(incomeType, monthlyIncomeOfSource);
        }
        return sourceOfIncomesTab;
    }

    private String getString(String x, Scanner in, String regex) {
        String s;
        do {
            System.out.println(x);
            s = in.next();
        }while (!StringValidator.validateString(s, regex));
        return s;
    }


}
