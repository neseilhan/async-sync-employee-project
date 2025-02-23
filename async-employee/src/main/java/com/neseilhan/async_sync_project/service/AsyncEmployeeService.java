package com.neseilhan.async_sync_project.service;

import com.neseilhan.async_sync_project.dto.Employee;

import java.util.concurrent.CompletableFuture;

public interface AsyncEmployeeService {
    CompletableFuture<Employee> getEmployee();
}
