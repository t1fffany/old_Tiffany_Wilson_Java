package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class AccountManager {

    private final List <String[]> customerData;

    private final List <Customer> convertedCustomerData;
    public AccountManager(List<String[]> customerData) {
        this.customerData = customerData;
        convertedCustomerData = new ArrayList<>();
    }

    public void addCustomerInformation() {
        for(var customer : customerData) {
            boolean hasItem = false;
            Customer data = new Customer();

            for (var thing : convertedCustomerData) {
                if (Objects.equals(thing.getName(), customer[1])) {
                    hasItem = true;
                    data = thing;
                    break;
                }
            }

            if (!hasItem) {
                data.setId(Integer.parseInt(customer[0]));
                data.setName(customer[1]);
                convertedCustomerData.add(data);
            }

            data.addCharges(Integer.parseInt(customer[2]), customer[3]);
        }
    }

    public List<Customer> viewCustomers () {
        return Collections.unmodifiableList(convertedCustomerData);
    }

    public List<Customer> positiveAccounts () {
        List<Customer> positiveBal = new ArrayList<>();
        for (var customer : convertedCustomerData) {
            if (customer.getBalance() > 0) {
                positiveBal.add(customer);
            }
        }
        return positiveBal;
    }

    public List<Customer>  negativeAccounts() {
        List<Customer> negativeBal = new ArrayList<>();
        for (var customer : convertedCustomerData) {
            if (customer.getBalance() < 0) {
                negativeBal.add(customer);
            }
        }
        return negativeBal;
    }
}
