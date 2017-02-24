package com.biblioteca.dao.intf;

import com.biblioteca.entitati.MyContactPage;

public interface MyContactPageIntf {

    public void update(MyContactPage contact);

    MyContactPage findById(int id);

}
