package com.inventine.dao.interface_;

import com.inventine.model.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface PaymentDaoInterface{

    public boolean create(Payment payment);

    public Payment getPayment(String paymentId);

    public List<Payment> getPayments(String condition);

    public Payment getPaymentCountSum(String query,String countSum);

    public boolean update(Payment payment);

    public int getCount(String condition) throws SQLException;

    public  int getCountAmount(String condition) throws SQLException;

    public ResultSet executeQuery(String query);

}