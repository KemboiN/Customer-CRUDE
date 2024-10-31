package com.KimTechnologies.customerRegistration.Repository;

import com.KimTechnologies.customerRegistration.Dto.CustomerRequest;
import com.KimTechnologies.customerRegistration.model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CustomerRepositoryTest
{
    @Autowired
    CustomerRepo repo;
    CustomerRequest customerRequest;
    Customer customer;

    @BeforeEach
    void setUp() {
        Customer customer= Customer.builder()
                .name("Kimutai Kemboi Nehemiah")
                .email("nehemiahkimutai32@gmail.com")
                .phone("0713595565")
                .dob(LocalDate.parse("1995-01-01"))
                .address("001 Nairobi")
                .gender("Male")
                .idNumber("32428432")
                .build();
           repo.save(customer);

                }

    @AfterEach
    void tearDown() {
        customer=null;
        repo.deleteAll();

                    }
                    @Test
                    void  testFindByEmail_Found(){
      assertThat(repo.findByEmail("nehemiahkimutai32@gmail.com").isPresent()).isTrue();

                    }
                    @Test
             void  testFindByEmail_Not_Found(){

        assertThat(repo.findByEmail("kimutaikemboi@gmail.com").isEmpty()).isTrue();

    }

}
