package com.neseilhan.async_sync_project.service;

import com.neseilhan.async_sync_project.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AsyncEmployeeServiceImpl implements AsyncEmployeeService {

    private static final Logger log = LoggerFactory.getLogger(AsyncEmployeeServiceImpl.class);

    @Override
    public CompletableFuture<Employee> getEmployee() {
        CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(() -> {
            log.info("Fetching Employee Name...");
            sleep();
            return "Nese ilhan";
        });

        CompletableFuture<String> addressFuture = CompletableFuture.supplyAsync(() -> {
            log.info("Fetching Employee Address...");
            sleep();
            return "123 Main St, Scranton, PA";
        });

        CompletableFuture<String> phoneFuture = CompletableFuture.supplyAsync(() -> {
            log.info("Fetching Employee Phone...");
            sleep();
            return "+123456789";
        });

        return CompletableFuture.allOf(nameFuture, addressFuture, phoneFuture)
                .thenApply(voidResult -> buildEmployee(nameFuture, addressFuture, phoneFuture));
    }
    private Employee buildEmployee(CompletableFuture<String> nameFuture, CompletableFuture<String> addressFuture, CompletableFuture<String> phoneFuture) {
        return Employee.builder()
                .id(UUID.randomUUID())
                .name(extractEmployeeField(nameFuture))
                .address(extractEmployeeField(addressFuture))
                .phone(extractEmployeeField(phoneFuture))
                .build();
    }
    private void sleep() {
        try {
            Thread.sleep(10000); //10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private String extractEmployeeField (CompletableFuture<String> fieldName ) {
        try {
            return fieldName .get();
        } catch (InterruptedException | ExecutionException e) {
            return "Error fetching data";
        }
    }
}
