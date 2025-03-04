package com.KimTechnologies.customerRegistration.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Table( name = "customerDb")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
  @Column(name = "kimutai kemboi nehemiah")
    private String name;
  @NotNull(message = "Enter valid ID number")
    private  String idNumber;
 @Past(message = "Enter valid Date of birth")
    private LocalDate dob;
 @NotNull(message = "Enter your Gender")
  private  String gender;
  @NotNull(message = "Enter you residential address")
    private  String address;
  @Pattern(regexp = "^07\\d{8}$")@NotNull
    private String phone;
  @Email(message = "valid email address")@NotNull
    private String email;



}
