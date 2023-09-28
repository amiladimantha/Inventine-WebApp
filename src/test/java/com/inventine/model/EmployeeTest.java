package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee;

    @BeforeEach
    void setUp() {
        this.employee = new Employee();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/Employee.csv", numLinesToSkip = 1)
    void getterSetter(String employeeId,String userId, int n_work_hours, int n_tasks) {

        this.employee.setEmployeeId(employeeId);
        this.employee.setUserId(userId);
        this.employee.setNWorkHours(n_work_hours);
        this.employee.setNTasks(n_tasks);

        assertEquals(userId,this.employee.getUserId());
        assertEquals(employeeId,this.employee.getEmployeeId());
        assertEquals(n_work_hours,this.employee.getNWorkHours());
        assertEquals(n_tasks,this.employee.getNTasks());

    }
}