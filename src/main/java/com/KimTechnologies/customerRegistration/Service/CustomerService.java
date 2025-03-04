package com.KimTechnologies.customerRegistration.Service;


import com.KimTechnologies.customerRegistration.Dto.CustomerRequest;
import com.KimTechnologies.customerRegistration.Dto.Response;
import com.KimTechnologies.customerRegistration.model.Customer;

import java.util.List;


public interface CustomerService {
    Response createAccount (CustomerRequest customerRequest);
    Response updateDetails(CustomerRequest customerRequest);
    List<Customer> ListCustomers();
    Response deleteCustomer(String email);
}
