package com.KimTechnologies.customerRegistration.Service;

import com.KimTechnologies.customerRegistration.Dto.CustomerRequest;
import com.KimTechnologies.customerRegistration.Dto.MessageRequest;
import com.KimTechnologies.customerRegistration.Dto.Response;
import com.KimTechnologies.customerRegistration.Repository.CustomerRepo;
import com.KimTechnologies.customerRegistration.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepo customerRepo;

    @Mock
    private SmsService smsService;  //Mock the SmsService

    @InjectMocks
    private CustomerServiceImpl customerService;

    AutoCloseable autoCloseable;
    Customer customer;
    CustomerRequest customerRequest;

    @BeforeEach
    void setUp() {
        autoCloseable = mock(AutoCloseable.class);

        customer = Customer.builder()
                .name("Kimutai Nehemiah")
                .email("nehemiahkimutai32@gmail.com")
                .phone("0713595565")
                .dob(LocalDate.parse("1995-01-01"))
                .gender("MALE")
                .address("29 NAIROBI")
                .idNumber("32428432")
                .build();

        customerRequest = CustomerRequest.builder()
                .name("Kimutai Nehemiah")
                .email("nehemiahkimutai32@gmail.com")
                .phone("0713595565")
                .dob(LocalDate.parse("1995-01-01"))
                .gender("MALE")
                .address("29 NAIROBI")
                .idNumber("32428432")
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateAccount() {
        when(customerRepo.findByEmail(customerRequest.getEmail())).thenReturn(Optional.empty());
        when(customerRepo.save(any(Customer.class))).thenReturn(customer);

        //Mock SmsService behavior
        doNothing().when(smsService).sendSms(any(MessageRequest.class));

        Response createdAccount = customerService.createAccount(customerRequest);

        assertNotNull(createdAccount);
        assertEquals("Congratulations, Successfully registered", createdAccount.getMessage());

        verify(customerRepo, times(1)).save(any(Customer.class));
        verify(smsService, times(1)).sendSms(any(MessageRequest.class)); //Verify SMS was sent
    }
    @Test
    void testUpdateDetails()
    {

    }
}
