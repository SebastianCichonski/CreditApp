package pl.javaskils.creditapp.client;

import pl.javaskils.creditapp.core.model.*;

import java.util.Arrays;
import java.util.List;

public class DummyCreditApplicationReader implements CreditApplicationReader{
    @Override
    public CreditApplication read(){
        final FamilyMember john = new FamilyMember("John", 18);
        final FamilyMember margaret = new FamilyMember("Margaret", 40);
        final FamilyMember susie = new FamilyMember("Susie", 5);
        List<FamilyMember> familyMembers = Arrays.asList(
                margaret,
                susie,
                john);
        ContactData contactData = ContactData.Builder
                .create()
                .withPhoneNumber("112233123")
                .withHomeAddress(new Address("Ziejkowa","Gostynin", "29", "09-500", "Mazowieckie"))
                .withCorrespondenceAddress(new Address("Ziejkowa","Gostynin", "29", "09-500", "Mazowieckie"))
                .withEmail("qweq@asdass.com")
                .build();

        NaturalPerson person = NaturalPerson.Builder
                .create()
                .withFamiliMember(familyMembers)
                .withContactData(contactData)
                .withPersonalData(PersonalData.Builder
                                .create()
                        .withName("Test")
                        .withLastName("Test")
                        .withMothersMaidenName("Test")
                        .withEducation(Education.MIDDLE)
                        .withMartialStatus(MartialStatus.MARRIED)
                        .build())
                .withFinanceData(new FinanceData(new SourceOfIncome(IncomeType.SELF_EMPLOYMENT, 10000))).build();
        PurposeOfLoan purposeOfLoan = new PurposeOfLoan(PurposeOfLoanType.MORTGAGE,(double) 50000, (byte) 30);
        CreditApplication creditApplication = CreditApplication.Buider
                .create()
                .withPerson(person)
                .withPurposeOfLoan(purposeOfLoan)
                .withGuarantors(null)
                .build();


        return creditApplication;
    }
}
