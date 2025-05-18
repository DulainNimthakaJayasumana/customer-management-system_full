package com.dulain.customer_management_system.service;

import com.dulain.customer_management_system.entity.Customer;
import com.dulain.customer_management_system.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> list() {
        return repo.findAll();
    }

    public Customer get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
    }

    @Transactional
    public Customer save(Customer c) {
        return repo.save(c);
    }

    @Transactional
    public Customer update(Long id, Customer in) {
        Customer c = get(id);
        c.setName(in.getName());
        c.setDateOfBirth(in.getDateOfBirth());
        c.setNic(in.getNic());
        c.setMobileNumbers(in.getMobileNumbers());
        c.setAddresses(in.getAddresses());
        c.setFamilyMembers(in.getFamilyMembers());
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

