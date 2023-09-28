package com.inventine.dao.interface_;

import com.inventine.model.Image;
import com.inventine.model.User;

public interface ImageDaoInterface {

    public boolean create(Image image);

    public Image getImage(String id);

    public boolean delete(Image image);
}
