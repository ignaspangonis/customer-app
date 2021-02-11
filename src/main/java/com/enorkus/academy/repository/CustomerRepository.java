package com.enorkus.academy.repository;

import com.enorkus.academy.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// nereikia @Repository, nes nekomunikuoja su DB,o feikina
public interface CustomerRepository {

    List<Customer> findAll();

    void insert(Customer customer);

    void deleteById(String customerId);
}
