package com.inventine.dao.interface_;

import com.inventine.model.RateCreator;

import java.sql.SQLException;
import java.util.List;

public interface RateCreatorDaoInterface{

    public boolean create(RateCreator rateCreator);

    public RateCreator getRateCreator(String rateCreatorId);

    public List<RateCreator> getRateCreators(String condition);

    public boolean update(RateCreator rateCreator);

    public int getCount(String condition) throws SQLException;

}