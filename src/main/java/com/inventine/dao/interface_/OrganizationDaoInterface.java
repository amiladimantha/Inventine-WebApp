package com.inventine.dao.interface_;

import com.inventine.model.Organization;

import java.sql.SQLException;
import java.util.List;

public interface OrganizationDaoInterface {
    public boolean create(Organization organization);

    public Organization getOrganization(String organizationId);

    public List<Organization> getOrganizations(String condition);

    public boolean update(Organization organization);

    public int getCount(String condition) throws SQLException;


}
