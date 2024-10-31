package com.PrestoTechnologies.customerRegistration.Controller;

import com.PrestoTechnologies.customerRegistration.Dto.CustomerRequest;
import com.PrestoTechnologies.customerRegistration.Dto.Response;
import com.PrestoTechnologies.customerRegistration.Repository.CustomerRepo;
import com.PrestoTechnologies.customerRegistration.Service.CustomerService;
import com.PrestoTechnologies.customerRegistration.Service.SmsService;
import com.PrestoTechnologies.customerRegistration.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    CustomerRepo repo;
    @Autowired
    CustomerService customerService;
    @Autowired
    SmsService smsService;
@PostMapping("/register")
    public Response createAccount(@RequestBody CustomerRequest customerRequest)
{
    return customerService.createAccount(customerRequest);
}
    @PutMapping("/update")
    public Response updateDetails(@RequestBody CustomerRequest customerRequest)
    {
        return customerService.updateDetails(customerRequest);
    }
    @GetMapping("/all")
    public List<Customer> ReadCustomers()
    {
        List <Customer> customerList =repo.findAll();
        return customerList;
    }
    @DeleteMapping("/delete")
    public  Response deleteCustomer(@RequestParam Long customerId)
    {
       return customerService.deleteCustomer(customerId);
    }
}
