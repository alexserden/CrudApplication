package com.alexserden.task.repository;

import java.util.List;
import com.alexserden.task.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastname);
}
