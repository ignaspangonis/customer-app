package com.enorkus.academy.service;

import com.enorkus.academy.entity.Customer;
import com.enorkus.academy.repository.CustomerRepository;
import com.enorkus.academy.repository.MemoryCustomerRepository;
import com.enorkus.academy.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class CustomerService {

    @Qualifier("memory-repository")
    private CustomerRepository customerRepository;

//    private final CountryCodeValidator countryCodeValidator;
//    private final CustomerAdultValidator customerAdultValidator;
    private final CustomerValidator customerValidator;

    public CustomerService() {
        customerRepository = new MemoryCustomerRepository();
        customerValidator = new CustomerValidator();
    }

    public List<Customer> fetchCustomers() {
        return customerRepository.findAll();
    }

    public void insertCustomer(Customer customer) {
        customerValidator.validateCustomer(customer);

        customer = new Customer.Builder(
                capitalize(customer.getFirstName()),
                capitalize(customer.getLastName()),
                formatNumber(customer.getPersonalNumber()))
                .middleName(customer.getMiddleName())
                .age(customer.getAge())
                .countryCode(customer.getCountryCode())
                .city(customer.getCity())
                .monthlyIncome(customer.getMonthlyIncome())
                .employer(customer.getEmployer())
                .gender(customer.getGender())
                .maritalStatus(customer.getMaritalStatus())
                .build();
        customerRepository.insert(customer);
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    public static String capitalize(String s) {
        if (s.isEmpty()) {
            return s;
        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    private String formatNumber(String s) {
        final int position = 4;
        if (s.length() < 5) {
            return s;
        }
        return s.substring(0, position) + '-' + s.substring(position);
    }

}
