
package com.inventine.dao.interface_;

import com.inventine.model.University;

import java.sql.SQLException;
import java.util.List;

public interface UniversityDaoInterface {
    public boolean create(University university);

    public University getUniversity(String universityId);

    public List<University> getUniversitys(String condition);

    public boolean update(University university);

    public int getCount(String condition) throws SQLException;



}
