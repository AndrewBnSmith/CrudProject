package com.xpanxion.springapplication.Repositories;
import com.xpanxion.springapplication.Models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
