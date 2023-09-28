package com.inventine.dao.interface_;

import com.inventine.model.Refund;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface RefundDaoInterface {

    public boolean create(Refund refund);

    public Refund getRefund(String refundId);

    public List<Refund> getRefunds(String condition);

    public boolean update(Refund refund);

    public int getCount(String condition) throws SQLException;

    public ResultSet executeQuery(String query);
}
