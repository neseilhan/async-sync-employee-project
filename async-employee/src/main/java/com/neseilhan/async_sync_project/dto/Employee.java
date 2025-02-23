package com.neseilhan.async_sync_project.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Employee {
    private UUID id;
    private String name;
    private String address;
    private String phone;
}
