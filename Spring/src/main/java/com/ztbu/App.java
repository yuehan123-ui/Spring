package com.ztbu;

import com.ztbu.dao.BookDao;
import com.ztbu.service.BookService;
import com.ztbu.service.impl.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        /*
        不用spring

        BookService bookService = new BookServiceImpl();
        bookService.save();

        */

        /*
         * 采用spring
         */
        //获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取资源 （获取对象）getBean
        BookService bookService =(BookService) ac.getBean("bookService");
        bookService.save();
    }
}
