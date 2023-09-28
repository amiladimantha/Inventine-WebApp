
package com.inventine.dao.interface_;

import com.inventine.model.PrivateOrganization;

import java.sql.SQLException;
import java.util.List;

public interface PrivateOrganizationDaoInterface {
    public boolean create(PrivateOrganization privateOrganization);

    public PrivateOrganization getPrivateOrganization(String privateOrganizationId);

    public List<PrivateOrganization> getPrivateOrganizations(String condition);

    public boolean update(PrivateOrganization privateOrganization);

    public int getCount(String condition) throws SQLException;



}
