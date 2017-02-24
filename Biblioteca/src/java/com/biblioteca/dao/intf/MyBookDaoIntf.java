package com.biblioteca.dao.intf;

import com.biblioteca.entitati.MyBook;
import java.util.List;

public interface MyBookDaoIntf {

    public void save(MyBook book);

    public void update(MyBook book);

    public void delete(MyBook book);

    MyBook findById(int bookId);

    List<MyBook> findByAuthor(String author);

    List<MyBook> findByName(String bookName);

    List<MyBook> findByGender(String gender);

    List<MyBook> findAll();
}
