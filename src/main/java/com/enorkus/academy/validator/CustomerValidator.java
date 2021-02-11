package com.enorkus.academy.validator;

import com.enorkus.academy.entity.Customer;

public class CustomerValidator {
    public void validateCustomer(Customer customer) {
        MandatoryValueValidator mandatoryValueValidator = new MandatoryValueValidator();
        CustomerAgeValidator customerAgeValidator = new CustomerAgeValidator();
        CountryCodeValidator countryCodeValidator = new CountryCodeValidator();
        mandatoryValueValidator.validate(customer.getFirstName(), "First name cannot be blank!");
        mandatoryValueValidator.validate(customer.getLastName(), "Last name cannot be blank!");
        mandatoryValueValidator.validate(customer.getPersonalNumber(), "Personal number cannot be blank!");
        customerAgeValidator.validate(customer.getAge(), "Must be 18 or older!");
        countryCodeValidator.validate(customer.getCountryCode(),"Country code can be blank or LT, LV, EE, SE!");
    }
}
