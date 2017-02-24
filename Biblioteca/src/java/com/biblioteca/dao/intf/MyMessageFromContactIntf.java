package com.biblioteca.dao.intf;

import com.biblioteca.entitati.MyMessageFromContact;
import java.util.List;

public interface MyMessageFromContactIntf {

    public void save(MyMessageFromContact message);

    public void delete(MyMessageFromContact message);

    MyMessageFromContact findById(int id);

    List<MyMessageFromContact> findAll();

}
