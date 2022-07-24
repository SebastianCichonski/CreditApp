package pl.javaskils.creditapp;

import pl.javaskils.creditapp.client.ConsoleReader;
import pl.javaskils.creditapp.core.CreditApplicationService;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.scoring.*;

public class Main {
    public static void main(String[] args){

        EducationCalculator educationCalculator = new EducationCalculator();
        MartialCalculator martialCalculator = new MartialCalculator();
        IncomeCalculator incomeCalculator = new IncomeCalculator();
        SourceOfIncomeCalculator sourceOfIncomeCalculator = new SourceOfIncomeCalculator();
        SelfEmployedScoringCalculator selfEmployedScoringCalculator =
                new SelfEmployedScoringCalculator();
        PersonScoringCalculatorFactory personScoringCalculatorFactory =
                new PersonScoringCalculatorFactory(selfEmployedScoringCalculator,educationCalculator,martialCalculator,incomeCalculator,sourceOfIncomeCalculator);

        CreditApplication creditApplication = new ConsoleReader().readInputParameters();
        CreditApplicationService service = new CreditApplicationService(personScoringCalculatorFactory);
        System.out.println(service.getDecision(creditApplication).getDecision());
    }

}