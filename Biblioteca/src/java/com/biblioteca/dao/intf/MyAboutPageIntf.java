package com.biblioteca.dao.intf;

import com.biblioteca.entitati.MyAboutPage;

public interface MyAboutPageIntf {

    public void update(MyAboutPage about);

    MyAboutPage findById(int id);
}
