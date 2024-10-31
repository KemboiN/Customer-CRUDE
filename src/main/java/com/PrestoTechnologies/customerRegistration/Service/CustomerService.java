package com.PrestoTechnologies.customerRegistration.Service;


import com.PrestoTechnologies.customerRegistration.Dto.CustomerRequest;
import com.PrestoTechnologies.customerRegistration.Dto.Response;
import com.PrestoTechnologies.customerRegistration.model.Customer;

import java.util.List;


public interface CustomerService {
    Response createAccount (CustomerRequest customerRequest);
    Response updateDetails(CustomerRequest customerRequest);
    List<Customer> ListCustomers();
    Response deleteCustomer(Long customerId);
}
