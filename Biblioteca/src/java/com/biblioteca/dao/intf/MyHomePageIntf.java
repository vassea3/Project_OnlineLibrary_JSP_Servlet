package com.biblioteca.dao.intf;

import com.biblioteca.entitati.MyHomePage;

public interface MyHomePageIntf {

    public void update(MyHomePage home);

    MyHomePage findById(int id);
}
