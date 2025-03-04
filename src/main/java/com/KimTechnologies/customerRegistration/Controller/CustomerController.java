package com.KimTechnologies.customerRegistration.Controller;

import com.KimTechnologies.customerRegistration.Dto.CustomerRequest;
import com.KimTechnologies.customerRegistration.Dto.Response;
import com.KimTechnologies.customerRegistration.Repository.CustomerRepo;
import com.KimTechnologies.customerRegistration.Service.CustomerService;
import com.KimTechnologies.customerRegistration.Service.SmsService;
import com.KimTechnologies.customerRegistration.model.Customer;
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
        List <Customer> customerList;
        customerList=repo.findAll();
        return customerList;
    }
    @DeleteMapping("/delete")
    public  Response deleteCustomer(@RequestParam String email)
    {
       return customerService.deleteCustomer(email);
    }
}
