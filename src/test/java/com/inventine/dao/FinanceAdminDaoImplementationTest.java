package com.inventine.dao;

import com.inventine.model.FinanceAdmin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FinanceAdminDaoImplementationTest {
    FinanceAdmin financeAdmin;
    FinanceAdminDaoImplementation financeAdminDao;

    @BeforeEach
    void setUp() {

        this.financeAdmin = new FinanceAdmin();
        this.financeAdminDao = new FinanceAdminDaoImplementation();
    }

    @Test
    void getCount() {
        assertEquals(financeAdminDao.getCount("financeAdminId=1"),1);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/FinanceAdmin.csv", numLinesToSkip = 1)
    void create(String finance_Admin_Id,String employee_id) {


        this.financeAdmin.setFinanceAdminId(finance_Admin_Id);
        this.financeAdmin.setEmployeeId(employee_id);


        assertTrue(this.financeAdminDao.create(financeAdmin));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/FinanceAdmin.csv", numLinesToSkip = 1)
    void getFinanceAdmin(String finance_Admin_Id,String employee_id) {

        this.financeAdmin = this.financeAdminDao.getFinanceAdmin(finance_Admin_Id);

        assertEquals(finance_Admin_Id, this.financeAdmin.getFinanceAdminId());
        assertEquals(employee_id, this.financeAdmin.getEmployeeId());


    }


    @ParameterizedTest
    @CsvFileSource(resources = "/model/FinanceAdmin.csv", numLinesToSkip = 1)
    void getFinanceAdmins(String finance_Admin_Id,String employee_id) {

        List<FinanceAdmin> ls = this.financeAdminDao.getFinanceAdmins("financeAdminId=1");

        this.financeAdmin.setFinanceAdminId(finance_Admin_Id);
        this.financeAdmin.setEmployeeId(employee_id);

        assertEquals(ls.get(0).getFinanceAdminId(),this.financeAdmin.getFinanceAdminId());
        assertEquals(ls.get(0).getEmployeeId(),this.financeAdmin.getEmployeeId());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/model/FinanceAdmin.csv", numLinesToSkip = 1)
    void update(String finance_Admin_Id,String employee_id) {

        this.financeAdmin.setFinanceAdminId(finance_Admin_Id);
        this.financeAdmin.setEmployeeId(employee_id);

        this.financeAdminDao.update(this.financeAdmin);

        FinanceAdmin updated = this.financeAdminDao.getFinanceAdmin(finance_Admin_Id);

        assertEquals(this.financeAdmin.getFinanceAdminId(),updated.getFinanceAdminId());
        assertEquals(this.financeAdmin.getEmployeeId(),updated.getEmployeeId());

    }

}
