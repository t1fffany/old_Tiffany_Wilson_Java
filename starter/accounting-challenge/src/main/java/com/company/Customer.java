package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int total = 0;
        for (var charge : charges) {
            total += charge.getCharge();
        }
        return total;
    }

    public void addCharges(int charge, String chargeDate){
        AccountRecord record = new AccountRecord();
        record.setCharge(charge);
        record.setChargeDate(chargeDate);
        charges.add(record);
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " balance: " + getBalance();
    }
}
