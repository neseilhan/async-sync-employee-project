package com.sync_employee.sync_employee.controller;

import com.sync_employee.sync_employee.dto.Employee;
import com.sync_employee.sync_employee.service.SyncEmployeeImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testSync")
public class SyncEmployeeController {
    private final SyncEmployeeImpl employeeService;

    public SyncEmployeeController(SyncEmployeeImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public Employee getEmployeeSync() {
        return employeeService.getEmployee();
    }
}
