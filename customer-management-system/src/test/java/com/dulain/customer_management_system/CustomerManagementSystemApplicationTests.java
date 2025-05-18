package com.dulain.customer_management_system;

import com.dulain.customer_management_system.entity.Customer;
import com.dulain.customer_management_system.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CustomerServiceTest {

	@Autowired private CustomerService svc;

	@Test
	void canCreateAndFetchCustomer() {
		Customer c = new Customer();
		c.setName("John Doe");
		c.setNic("991234567V");
		c.setDateOfBirth(LocalDate.of(1999, 1, 1));

		Customer saved  = svc.save(c);
		Customer fetched = svc.get(saved.getId());

		assertThat(fetched.getNic()).isEqualTo("991234567V");
	}
}