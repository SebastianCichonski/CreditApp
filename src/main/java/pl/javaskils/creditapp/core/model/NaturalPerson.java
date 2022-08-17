package pl.javaskils.creditapp.core.model;

import java.util.List;

public class NaturalPerson extends Person{
    private final String pesel;
    private PersonalData personalData;
    private ContactData contactData;
    private FinanceData financeData;
    private List<FamilyMember> familyMembers;

    private NaturalPerson(PersonalData personalData, ContactData contactData, FinanceData financeData, String pesel, List<FamilyMember> familyMembers) {
        super(personalData, contactData, financeData, familyMembers);
        this.pesel = pesel;
    }

    public static class Builder{
        private String pesel;
        private PersonalData personalData;
        private ContactData contactData;
        private FinanceData financeData;
        private List<FamilyMember> familyMembers;

        private Builder(){}

        public static Builder create(){
            return new Builder();
        }

        public NaturalPerson build(){
            return new NaturalPerson(personalData, contactData, financeData, pesel, familyMembers);
        }

        public Builder withPesel(String pesel){
            this.pesel = pesel;
            return this;
        }

        public Builder withFamiliMember(List<FamilyMember> familyMembers){
            this.familyMembers = familyMembers;
            return this;

        }

        public Builder withPersonalData(PersonalData personalData){
            this.personalData = personalData;
            return this;
        }

        public Builder withContactData(ContactData contactData){
            this.contactData = contactData;
            return this;
        }

        public Builder withFinanceData(FinanceData financeData){
            this.financeData = financeData;
            return this;
        }
    }
}
