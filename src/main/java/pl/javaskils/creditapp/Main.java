package pl.javaskils.creditapp;

import pl.javaskils.creditapp.client.ConsoleReader;
import pl.javaskils.creditapp.client.CreditApplicationReader;
import pl.javaskils.creditapp.client.DummyCreditApplicationReader;
import pl.javaskils.creditapp.core.CreditApplicationDecision;
import pl.javaskils.creditapp.core.CreditApplicationManager;
import pl.javaskils.creditapp.core.CreditApplicationService;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.scoring.*;
import pl.javaskils.creditapp.core.validation.CreditApplicationValidator;
import pl.javaskils.creditapp.core.validation.PersonValidator;
import pl.javaskils.creditapp.core.validation.PersonalDataValidator;
import pl.javaskils.creditapp.core.validation.PurposeOfLoanValidator;

public class Main {
    public static void main(String[] args){
        CreditApplicationReader reader = new DummyCreditApplicationReader();
        EducationCalculator educationCalculator = new EducationCalculator();
        MartialCalculator martialCalculator = new MartialCalculator();
        IncomeCalculator incomeCalculator = new IncomeCalculator();
        SourceOfIncomeCalculator sourceOfIncomeCalculator = new SourceOfIncomeCalculator();
        GuarantorsCalculator guarantorsCalculator = new GuarantorsCalculator();
        CreditApplicationValidator creditApplicationValidator = new CreditApplicationValidator(new PersonValidator(new PersonalDataValidator()),new PurposeOfLoanValidator());
        SelfEmployedScoringCalculator selfEmployedScoringCalculator =
                new SelfEmployedScoringCalculator();
        PersonScoringCalculatorFactory personScoringCalculatorFactory =
                new PersonScoringCalculatorFactory(selfEmployedScoringCalculator,educationCalculator,martialCalculator,incomeCalculator,sourceOfIncomeCalculator,guarantorsCalculator);

        CreditApplication creditApplication = reader.read();



        CreditApplicationService service = new CreditApplicationService(personScoringCalculatorFactory,creditApplicationValidator);
        CreditApplicationManager manager = new CreditApplicationManager(service);

        manager.add(reader.read());
        manager.add(reader.read());
        manager.add(reader.read());
        manager.add(reader.read());
        manager.add(reader.read());

        manager.startProcessing();

//        CreditApplicationDecision decision = service.getDecision(creditApplication);
//        System.out.println(decision.getDecision());
    }

}