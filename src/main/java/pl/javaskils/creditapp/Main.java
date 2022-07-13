package pl.javaskils.creditapp;

import pl.javaskils.creditapp.client.ConsoleReader;
import pl.javaskils.creditapp.core.CreditApplicationService;
import pl.javaskils.creditapp.core.PersonScoringCalculator;
import pl.javaskils.creditapp.core.model.CreditApplication;
import pl.javaskils.creditapp.core.scoring.*;

public class Main {
    public static void main(String[] args){

        NaturalPersonScoringCalculator naturalPersonScoringCalculator =
                new NaturalPersonScoringCalculator(new IncomeCalculator(), new MartialCalculator(), new EducationCalculator(), new SourceOfIncomeCalculator());
        SelfEmployedScoringCalculator selfEmployedScoringCalculator =
                new SelfEmployedScoringCalculator(new IncomeCalculator(), new MartialCalculator(), new EducationCalculator(), new SourceOfIncomeCalculator());

        CreditApplication creditApplication = new ConsoleReader().readInputParameters();
        CreditApplicationService service = new CreditApplicationService(new PersonScoringCalculatorFactory(naturalPersonScoringCalculator, selfEmployedScoringCalculator));
        System.out.println(service.getDecision(creditApplication).getDecision());
    }

}