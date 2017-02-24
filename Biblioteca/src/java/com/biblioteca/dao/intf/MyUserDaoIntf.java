package com.biblioteca.dao.intf;

import com.biblioteca.entitati.MyUser;

public interface MyUserDaoIntf {

    MyUser getMyUserByNameAndPassword(String userName, String password);
}
