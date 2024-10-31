package com.PrestoTechnologies.customerRegistration.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MessageRequest {
    private final String message;
    private  final String phoneNumber;
    private  final  String email;

}
