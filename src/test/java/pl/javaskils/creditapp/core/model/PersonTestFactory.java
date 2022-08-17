package pl.javaskils.creditapp.core.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonTestFactory {
    public static NaturalPerson create(int numOfDependants, Education education, MartialStatus martialStatus){
        List<FamilyMember> familyMembers = new ArrayList<>();
        for(int i = 0; i < numOfDependants; i++){
            familyMembers.add(new FamilyMember("John", 18));
        }
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("Test")
                .withLastName("Testtest")
                .withMothersMaidenName("Test")
                .withEducation(education)
                .withMartialStatus(martialStatus)
                .build();
        return  NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withFamiliMember(familyMembers)
                .withContactData(ContactData.Builder
                        .create().withEmail("rest@test.com").withPhoneNumber("123123123")
                        .withCorrespondenceAddress(new Address("test", "test", "1", "00-000", "test"))
                        .withHomeAddress(new Address("test", "test", "1", "00-000", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 12000)))
                .build();
    }

    public static Person create(Education education){
        List<FamilyMember> familyMembers = Arrays.asList(new FamilyMember("John", 18),
                new FamilyMember("Jane", 40));
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("Test")
                .withLastName("Testtest")
                .withMothersMaidenName("Test")
                .withEducation(education)
                .withMartialStatus(MartialStatus.SINGLE)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withFamiliMember(familyMembers)
                .withContactData(ContactData.Builder
                        .create().withEmail("rest@test.com").withPhoneNumber("123123123")
                        .withCorrespondenceAddress(new Address("test", "test", "1", "00-000", "test"))
                        .withHomeAddress(new Address("test", "test", "1", "00-000", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 12000)))
                .build();
    }

    public static Person create(){
        List<FamilyMember> familyMembers = Arrays.asList(new FamilyMember("John", 18),
                new FamilyMember("Jane", 40));
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("Test")
                .withLastName("Testtest")
                .withMothersMaidenName("Test")
                .withEducation(Education.MIDDLE)
                .withMartialStatus(MartialStatus.SINGLE)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withFamiliMember(familyMembers)
                .withContactData(ContactData.Builder
                        .create().withEmail("rest@test.com").withPhoneNumber("123123123")
                        .withCorrespondenceAddress(new Address("test", "test", "1", "00-000", "test"))
                        .withHomeAddress(new Address("test", "test", "1", "00-000", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 12000)))
                .build();
    }

    public static SelfEmployed create(int yearsSinceFounded, double totalMonthlyIncomInPln, int numOfDependants, Education education, MartialStatus martialStatus){
        List<FamilyMember> familyMembers = new ArrayList<>();
        for(int i = 0; i < numOfDependants; i++){
            familyMembers.add(new FamilyMember("John", 18));
        }
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("Test")
                .withLastName("Testtest")
                .withMothersMaidenName("Test")
                .withEducation(education)
                .withMartialStatus(martialStatus)
                .build();
        return SelfEmployed.Builder
                .create()
                .withYearsSinceFounded(yearsSinceFounded)
                .withFamiliMembers(familyMembers)
                .withPersonalData(personalData)
                .withContactData(ContactData.Builder
                        .create().withEmail("rest@test.com").withPhoneNumber("123123123")
                        .withCorrespondenceAddress(new Address("test", "test", "1", "00-000", "test"))
                        .withHomeAddress(new Address("test", "test", "1", "00-000", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomInPln)))
                .build();
    }

    public static NaturalPerson create( double totalMonthlyIncomInPln, int numOfDependants, Education education, MartialStatus martialStatus){
        List<FamilyMember> familyMembers = new ArrayList<>();
        for(int i = 0; i < numOfDependants; i++){
            familyMembers.add(new FamilyMember("John", 18));
        }
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("Test")
                .withLastName("Testtest")
                .withMothersMaidenName("Test")
                .withEducation(education)
                .withMartialStatus(martialStatus)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withFamiliMember(familyMembers)
                .withContactData(ContactData.Builder
                        .create().withEmail("rest@test.com").withPhoneNumber("123123123")
                        .withCorrespondenceAddress(new Address("test", "test", "1", "00-000", "test"))
                        .withHomeAddress(new Address("test", "test", "1", "00-000", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, totalMonthlyIncomInPln)))
                .build();
    }

    public static Person create(MartialStatus martialStatus) {
        List<FamilyMember> familyMembers = Arrays.asList(new FamilyMember("John", 18),
                new FamilyMember("Jane", 40));
        PersonalData personalData = PersonalData.Builder
                .create()
                .withName("Test")
                .withLastName("Testtest")
                .withMothersMaidenName("Test")
                .withEducation(Education.MIDDLE)
                .withMartialStatus(martialStatus)
                .build();
        return NaturalPerson.Builder
                .create()
                .withPersonalData(personalData)
                .withFamiliMember(familyMembers)
                .withContactData(ContactData.Builder
                        .create().withEmail("rest@test.com").withPhoneNumber("123123123")
                        .withCorrespondenceAddress(new Address("test", "test", "1", "00-000", "test"))
                        .withHomeAddress(new Address("test", "test", "1", "00-000", "test"))
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 12000)))
                .build();
    }

    public static Person create(int numOfDependants, SourceOfIncome... sourceOfIncomes){
        List<FamilyMember> familyMembers = new ArrayList<>();
        for(int i = 0; i < numOfDependants; i++){
            familyMembers.add(new FamilyMember("John", 18));
        }
                PersonalData personalData = PersonalData.Builder
                .create()
                .withName("Test")
                .withLastName("Testtest")
                .withMothersMaidenName("Test")
                .withEducation(Education.TERTIARY)
                .withMartialStatus(MartialStatus.SEPARATED)
                .build();
        return SelfEmployed.Builder
                .create()
                .withPersonalData(personalData)
                .withFamiliMembers(familyMembers)
                .withContactData(ContactData.Builder
                        .create().withEmail("rest@test.com").withPhoneNumber("123123123")
                        .withCorrespondenceAddress(new Address("test", "test", "1", "00-000", "test"))
                        .withHomeAddress(new Address("test", "test", "1", "00-000", "test"))
                        .build())
                .withFinanceData(new FinanceData(sourceOfIncomes))
                .build();
    }
}
