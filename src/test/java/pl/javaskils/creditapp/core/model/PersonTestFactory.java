package pl.javaskils.creditapp.core.model;

public class PersonTestFactory {
    public static NaturalPerson create(int numOfDependants, Education education, MartialStatus martialStatus){
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withNumOfFamilyDependants(numOfDependants)
                .withEducation(education)
                .withMartialStatus(martialStatus)
                .build();
        return  NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 12000)))
                .build();
    }

    public static Person create(Education education){
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withNumOfFamilyDependants(2)
                .withEducation(education)
                .withMartialStatus(MartialStatus.SINGLE)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

    public static Person create(){
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withNumOfFamilyDependants(2)
                .withEducation(Education.MIDDLE)
                .withMartialStatus(MartialStatus.SINGLE)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

    public static SelfEmployed create(int yearsSinceFounded, double totalMonthlyIncomInPln, int numOfDependents, Education education, MartialStatus martialStatus){
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withNumOfFamilyDependants(numOfDependents)
                .withEducation(education)
                .withMartialStatus(martialStatus)
                .build();
        return SelfEmployed.Builder
                .create()
                .withYearsSinceFounded(yearsSinceFounded)
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomInPln)))
                .build();
    }

    public static NaturalPerson create( double totalMonthlyIncomInPln, int numOfDependents, Education education, MartialStatus martialStatus){
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withNumOfFamilyDependants(numOfDependents)
                .withEducation(education)
                .withMartialStatus(martialStatus)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomInPln)))
                .build();
    }

    public static Person create(MartialStatus martialStatus) {
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withNumOfFamilyDependants(2)
                .withEducation(Education.MIDDLE)
                .withMartialStatus(martialStatus)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(null)
                .build();
    }

    public static Person create(int numOfDependants, SourceOfIncome... sourceOfIncomes){
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("test")
                .withLastName("test")
                .withMothersMaidenName("test")
                .withNumOfFamilyDependants(numOfDependants)
                .withEducation(Education.TERTIARY)
                .withMartialStatus(MartialStatus.SEPARATED)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withContactData(null)
                .withFinanceData(new FinanceData(sourceOfIncomes))
                .build();
    }
}
