package com.sync_employee.sync_employee.service;

import com.sync_employee.sync_employee.dto.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SyncEmployeeImpl implements SyncEmployee {

    private static final Logger log = LoggerFactory.getLogger(SyncEmployeeImpl.class);

    @Override
    public Employee getEmployee() {
        log.info("Fetching Employee Name...");
        String name = getName();

        log.info("Fetching Employee Address...");
        String address = getAddress();

        log.info("Fetching Employee Phone...");
        String phone = getPhone();

        return buildEmployee(name, address, phone);
    }
    private Employee buildEmployee(String name, String address, String phone) {
        return Employee.builder()
                .id(UUID.randomUUID())
                .name(name)
                .address(address)
                .phone(phone)
                .build();
    }

    private String getName() {
        sleep();
        return "Nese ilhan";
    }

    private String getAddress() {
        sleep();
        return "123 Main St, Scranton, PA";
    }

    private String getPhone() {
        sleep();
        return "+123456789";
    }

    private void sleep() {
        try {
            Thread.sleep(1000); // 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
