package com.inventine.dao.interface_;

import com.inventine.model.Creds;
import com.inventine.model.Verification;

import java.util.List;

public interface VerificationDoaInterface {

    public int getCount(String condition);

    public boolean create(Verification verification);

    public Verification getVerification(String id);

    public List<Verification> getVerifications(String condition);

    public boolean update(Verification verification);
}
