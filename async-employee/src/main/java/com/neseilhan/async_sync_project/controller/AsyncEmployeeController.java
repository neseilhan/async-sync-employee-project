package com.neseilhan.async_sync_project.controller;

import com.neseilhan.async_sync_project.dto.Employee;
import com.neseilhan.async_sync_project.service.AsyncEmployeeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class AsyncEmployeeController {
    private final AsyncEmployeeServiceImpl employeeService;
    private static final Logger log = LoggerFactory.getLogger(AsyncEmployeeController.class);

    public AsyncEmployeeController(AsyncEmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/testAsync")
    public String testAsync() {
        log.info("Starting Async Calls");
        CompletableFuture<Employee> employeeFuture = employeeService.getEmployee();
        return employeeFuture.join().toString();
    }
}
