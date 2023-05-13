package com.ztbu.service.impl;

import com.ztbu.service.BookService;
import com.ztbu.dao.BookDao;

public class BookServiceImpl implements BookService {
    private BookDao bookDao ;
    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}