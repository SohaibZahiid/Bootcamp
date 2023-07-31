package com.crudjpa.controllers;

import com.crudjpa.entities.Customer;
import com.crudjpa.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted";
    }


    @PatchMapping("update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer existingCustomer = customerService.findCustomerById(id);
        if(existingCustomer == null) {
            return null;
        }

        existingCustomer.setName(customer.getName());
        existingCustomer.setSurname(customer.getSurname());
        existingCustomer.setBirthdate(customer.getBirthdate());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setPostcode(customer.getPostcode());
        existingCustomer.setDirection(customer.getDirection());
        existingCustomer.setCountry(customer.getCountry());

        return customerService.updateCustomer(existingCustomer);

    }
}
