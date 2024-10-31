package com.PrestoTechnologies.customerRegistration.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest
{
    @Schema(description = "Full names", example = "Kimutai Kemboi Nehemiah", required = true)
    private String name;
    @Schema(description = "ID/Number", example = "32428432", required = true)
    private  String idNumber;
    @Schema(description = "Date of Birth", example = "1970-0206", required = true)
    private LocalDate dob;
    @Schema(description = "Gender", example = "Male", required = true)
    private String gender;
    @Schema(description = "Residential address", example = "001 NAIROBI", required = true)
    private  String address;
    @Schema(description = "Phone number", example = "0713595565", required = true)
    private String phone;
    @Schema(description = "Email", example = "nehemiahkimutai32@gmail.com", required = true)
    private String email;
    @Schema(description = "Password", example = "", required = true)
    private String password;

}
