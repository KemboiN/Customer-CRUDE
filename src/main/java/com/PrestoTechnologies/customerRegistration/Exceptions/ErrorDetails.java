package com.PrestoTechnologies.customerRegistration.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
@AllArgsConstructor
public class ErrorDetails {
    private LocalDate timestamp;
    private String code;
    private String Message;
}
