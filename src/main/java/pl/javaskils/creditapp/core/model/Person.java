package pl.javaskils.creditapp.core.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Person {
    private static final Logger LOG = LoggerFactory.getLogger(FinanceData.class);
    protected PersonalData personalData;
    protected ContactData contactData;
    protected FinanceData financeData;

    protected Person(PersonalData personalData, ContactData contactData, FinanceData financeData) {
        this.personalData = personalData;
        this.contactData = contactData;
        this.financeData = financeData;
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

    public double sumOfIncome(){
        double totalMonthlyIncom = 0;

        for(SourceOfIncome sourceOfIncome : financeData.getSourceOfIncomes() ){
            totalMonthlyIncom += sourceOfIncome.getNetMonthlyIncome();
        }
        LOG.info("Sum of income: " + totalMonthlyIncom);
        return totalMonthlyIncom;
    }
}
