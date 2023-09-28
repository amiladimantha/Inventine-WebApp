package com.inventine.dao.interface_;

import com.inventine.model.Investor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.inventine.model.FinanceAdmin;

import java.sql.SQLException;
import java.util.List;

public interface FinanceAdminDaoInterface {

    public boolean create(FinanceAdmin financeAdmin);

    public FinanceAdmin getFinanceAdmin(String financeAdminId);

    public List<FinanceAdmin> getFinanceAdmins(String condition);

    public boolean update(FinanceAdmin financeAdmin);

    public int getCount(String condition) throws SQLException;

    public ResultSet executeQuery(String query);

}
