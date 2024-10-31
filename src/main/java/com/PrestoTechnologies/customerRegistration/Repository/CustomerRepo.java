package com.PrestoTechnologies.customerRegistration.Repository;

import com.PrestoTechnologies.customerRegistration.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer ,Long >
{
 Optional<Customer> findByEmail(String email);
Optional<Customer> existsByEmailAndIdNumberAndPhone(String email, String idNumber, String phone);
}
