package com.enorkus.academy.entity;


import java.math.BigDecimal;

public class Customer {
    private Customer() {

    }

    public static class Builder {
        private String id;

        //Mandatory
        private String firstName;
        private String lastName;
        private String personalNumber;

        //Optional
        private String middleName;
        private int age;
        private String countryCode;
        private String city;
        private BigDecimal monthlyIncome;
        private String employer;
        private String gender;
        private String maritalStatus;

        public Builder(String firstName,
                       String lastName,
                       String personalNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.personalNumber = personalNumber;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder countryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder employer(String employer) {
            this.employer = employer;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder maritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
            return this;
        }

        public Builder monthlyIncome(BigDecimal monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.firstName = this.firstName;
            customer.lastName = this.lastName;
            customer.personalNumber = this.personalNumber;
            customer.middleName = this.middleName;
            customer.age = this.age;
            customer.countryCode = this.countryCode;
            customer.city = this.city;
            customer.monthlyIncome = this.monthlyIncome;
            customer.employer = this.employer;
            customer.gender = this.gender;
            customer.maritalStatus = this.maritalStatus;
            return customer;
        }
    }
    private String id;

    //Mandatory
    private String firstName;
    private String lastName;
    private String personalNumber;

    //Optional
    private String middleName;
    private int age;
    private String countryCode;
    private String city;
    private BigDecimal monthlyIncome;
    private String employer;
    private String gender;
    private String maritalStatus;



    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCity() {
        return city;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public String getGender() {
        return gender;
    }

    public String getEmployer() {
        return employer;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setId(String id) {
        this.id = id;
    }
}
