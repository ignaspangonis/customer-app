package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class CustomerService {

    private MemoryCustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new MemoryCustomerRepository();
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void saveCustomer(@RequestBody Customer customer) {
        String firstName = customer.getFirstName();
        if(firstName != null && !firstName.isEmpty()) {
            firstName = customer.getFirstName().substring(0, 1).toUpperCase() + customer.getFirstName().substring(1);
        }

        String lastName = customer.getLastName();
        if(lastName != null && !lastName.isEmpty()) {
            lastName = customer.getLastName().substring(0, 1).toUpperCase() + customer.getLastName().substring(1);
        }

        String personalNumber = customer.getPersonalNumber();
        if(personalNumber != null && !personalNumber.isEmpty() && personalNumber.length() > 4) {
            personalNumber = customer.getPersonalNumber().substring(0, 4) + "-" + customer.getPersonalNumber().substring(4, customer.getPersonalNumber().length());
        }

        Customer customerToSave = new Customer.CustomerBuilder(firstName, lastName, personalNumber)
                .middleName(customer.getMiddleName())
                .age(customer.getAge())
                .countryCode(customer.getCountryCode())
                .city(customer.getCity())
                .monthlyIncome(customer.getMonthlyIncome())
                .employer(customer.getEmployer())
                .gender(customer.getGender())
                .maritalStatus(customer.getMaritalStatus())
                .build();

        customerRepository.insert(customerToSave);
    }

    public void deleteCustomer(@PathVariable String customerId) {
        customerRepository.deleteById(customerId);
    }
}
