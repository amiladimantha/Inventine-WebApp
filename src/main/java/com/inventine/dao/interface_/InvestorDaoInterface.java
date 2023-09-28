package com.inventine.dao.interface_;

import com.inventine.model.Investor;

import java.sql.SQLException;
import java.util.List;

public interface InvestorDaoInterface{

    public boolean create(Investor investor);

    public Investor getInvestor(String investorId);

    public List<Investor> getInvestors(String condition);

    public boolean update(Investor investor);

    public int getCount(String condition) throws SQLException;

}