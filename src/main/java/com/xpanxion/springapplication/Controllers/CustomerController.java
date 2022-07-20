package com.xpanxion.springapplication.Controllers;

import com.xpanxion.springapplication.Models.Customer;
import com.xpanxion.springapplication.Repositories.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping ("/")
    public String home(){
        return  "home.jsp";
    }

    @GetMapping("/customers")
    public List<Customer> list() {
        return (List<Customer>)customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        return customerRepository.findById(id).get();
    }

    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
    }

    @PutMapping("/update/id/{id}")
    public void Update (@PathVariable("id") int id){
        Customer customer = this.customerRepository.findById(id).get();
        customer.setFirstName(customer.getFirstName());
        customer.setLastName(customer.getLastName());
        this.customerRepository.save(customer);
    }

    @DeleteMapping("/products/{id}")
    public void deleteCustomer(@PathVariable("id") int id) {
        customerRepository.deleteById(id);
    }

}
