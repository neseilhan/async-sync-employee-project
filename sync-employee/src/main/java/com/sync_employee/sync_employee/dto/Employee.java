package com.sync_employee.sync_employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private UUID id;
    private String name;
    private String address;
    private String phone;
}
