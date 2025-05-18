package com.dulain.customer_management_system.controller;


import com.dulain.customer_management_system.entity.Customer;
import com.dulain.customer_management_system.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin
public class CustomerController {

    private final CustomerService svc;

    public CustomerController(CustomerService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Customer> list() {
        return svc.list();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        return svc.get(id);
    }

    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody Customer c) {
        return ResponseEntity.ok(svc.save(c));
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id,
                           @Valid @RequestBody Customer c) {
        return svc.update(id, c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        svc.delete(id);
    }
}