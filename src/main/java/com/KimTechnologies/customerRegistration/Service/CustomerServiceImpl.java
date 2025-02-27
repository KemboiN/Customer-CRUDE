package com.KimTechnologies.customerRegistration.Service;

import com.KimTechnologies.customerRegistration.Exceptions.CustomerRegisteredException;
import com.KimTechnologies.customerRegistration.Dto.CustomerRequest;
import com.KimTechnologies.customerRegistration.Dto.MessageRequest;
import com.KimTechnologies.customerRegistration.Dto.Response;
import com.KimTechnologies.customerRegistration.Repository.CustomerRepo;
import com.KimTechnologies.customerRegistration.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    CustomerRepo repo;
    @Autowired
    SmsService smsService;
    @Autowired
    PasswordEncoder passwordEncoder;
    private  CustomerRequest customerRequest;
    @Override
    @Transactional
    public Response createAccount(CustomerRequest customerRequest) {
        Optional<Customer> customerOptional=repo.findByEmail(customerRequest.getEmail());
        if (!customerOptional.isPresent())
        {
            Customer customer=Customer.builder()
                    .name(customerRequest.getName())
                    .email(customerRequest.getEmail())
                    //.password(passwordEncoder.encode(customerRequest.getPassword()))
                    .dob(customerRequest.getDob())
                    .phone(customerRequest.getPhone())
                    .address(customerRequest.getAddress())
                    .gender(customerRequest.getGender())
                    .idNumber(customerRequest.getIdNumber())
                    .build();

            repo.save(customer);
            MessageRequest messageRequest= MessageRequest.builder()
                    .message("")
                    .phoneNumber(customerRequest.getPhone())
                    .build();
            smsService.sendSms(messageRequest);
            return Response.builder()
                    .message("Congratulations, Successfully registered")
                    .build();
        }
           else {
              throw  new CustomerRegisteredException("the customer is already registered");}
    }

    @Override
    public Response updateDetails(CustomerRequest customerRequest) {

        Optional<Customer> customerOptional=repo.findByEmail(customerRequest.getEmail());
        if (customerOptional.isPresent())
        {
Customer updateDetails= customerOptional.get();
            if (updateDetails.getName()!=null){
            updateDetails.setName(customerRequest.getName());
           }
            if (updateDetails.getEmail()!=null){
            updateDetails.setEmail(customerRequest.getEmail());
        }
            if (updateDetails.getDob()!=null){
            updateDetails.setDob(customerRequest.getDob());
        }
            if (updateDetails.getAddress()!=null){
            updateDetails.setAddress(customerRequest.getAddress());
        }
            if (updateDetails.getGender()!=null){
            updateDetails.setGender(customerRequest.getGender());
        }
            if (updateDetails.getIdNumber()!=null){
            updateDetails.setIdNumber(customerRequest.getIdNumber());
        }
            if (updateDetails.getPhone()!=null){
            updateDetails.setPhone(customerRequest.getPhone());
        }
        repo.save(updateDetails);
            return Response.builder()
                    .message("Details updated Successfully").build();
        }
        else {
            return Response.builder()
                    .message("Account not Found!!").build();
        }
    }
    @Override
    public List<Customer> ListCustomers()
    {
        List <Customer> customerList =repo.findAll();
        return customerList;
    }
    @Override
    public Response deleteCustomer(Long customerId) {
        Optional<Customer>customerOptional=repo.findById(customerId);
        if (customerOptional.isPresent())
        {
           repo.deleteById(customerId);
            return Response.builder()
                    .message("Deleted successfully")
                    .build();
        }
        return Response.builder()
                .message("CustomerId not found")
                .build();
    }

}
