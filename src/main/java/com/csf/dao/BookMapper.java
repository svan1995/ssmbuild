package com.csf.dao;

import com.csf.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int addBook(Book book);

    int deleteBookById(@Param("bookId") int id);

    int updateBook(Book book);

    Book queryBookById(@Param("bookId") int id);

    List<Book> queryAllBook();

    Book queryBooKByName(@Param("bookName") String bookName);
}
