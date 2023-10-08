package com.cokepepsi.service;

import com.cokepepsi.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author CokePepsi
 * @date 2023/9/18 21:19
 */
@Service
public class BookService {
//    @Qualifier("bookDao")
//    @Autowired(required = false)
    @Resource

    @Inject
    private BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }

    public void print() {
        System.out.println(bookDao);
    }
}
