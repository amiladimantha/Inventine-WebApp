package com.inventine.dao.interface_;

import com.inventine.model.Creds;

import java.util.List;

public interface CredsDaoInterface {

    public int getCount(String condition);

    public int create(Creds creds);

    public Creds getCreds(String userid);

    public List<Creds> getManyCreds(String condition);

    public boolean update(Creds creds);


}
