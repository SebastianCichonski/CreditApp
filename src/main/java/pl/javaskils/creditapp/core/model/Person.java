package pl.javaskils.creditapp.core.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Person {
    private static final Logger LOG = LoggerFactory.getLogger(FinanceData.class);
    protected PersonalData personalData;
    protected ContactData contactData;
    protected FinanceData financeData;
    protected List<FamilyMember> familyMembers;

    protected Person(PersonalData personalData, ContactData contactData, FinanceData financeData, List<FamilyMember> familyMembers) {
        this.personalData = personalData;
        this.contactData = contactData;
        this.financeData = financeData;
        this.familyMembers = familyMembers;
        Collections.sort(this.familyMembers);
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }


    public List<FamilyMember> getFamilyMembersSortedByName(){
        List<FamilyMember> copy = new ArrayList<>(this.familyMembers);
        Collections.sort(copy, new FamilyMemberNameComparator());
        return copy;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public FinanceData getFinanceData() {
        return financeData;
    }

    public int getNumOfFamilyDependants() {
        return 1 + this.familyMembers.size();
    }

    public double sumOfIncome(){
        double totalMonthlyIncom = 0;

        for(SourceOfIncome sourceOfIncome : financeData.getSourceOfIncomes() ){
            totalMonthlyIncom += sourceOfIncome.getNetMonthlyIncome();
        }
        LOG.info("Sum of income: " + totalMonthlyIncom);
        return totalMonthlyIncom;
    }
}
