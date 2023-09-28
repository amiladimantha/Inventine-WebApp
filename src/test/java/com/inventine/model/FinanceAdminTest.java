package com.inventine.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinanceAdminTest {
    FinanceAdmin financeAdmin;

    @BeforeEach
    void setUp() {
        this.financeAdmin = new FinanceAdmin();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/FinanceAdmin.csv", numLinesToSkip = 1)
    void getterSetter(String employeeId,String financeAdminId) {

        this.financeAdmin.setFinanceAdminId(financeAdminId);
        this.financeAdmin.setEmployeeId(employeeId);

        assertEquals(employeeId,this.financeAdmin.getEmployeeId());
        assertEquals(financeAdminId,this.financeAdmin.getFinanceAdminId());


    }
}
