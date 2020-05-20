package com.csf.controller;

import com.csf.pojo.Book;
import com.csf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Book> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id){
        Book book = bookService.queryBookById(id);
        System.out.println(book);
        model.addAttribute("book",book);
        return "updateBook";
    }

    @RequestMapping("updateBook")
    public String updateBook(Model model, Book book){
        bookService.updateBook(book);
//        Book abook = bookService.queryBookById(book.getBookID());
//        model.addAttribute("lists",books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId")int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){
        System.out.println(queryBookName);
        List<Book> list = new ArrayList<Book>();
        if (StringUtils.isEmpty(queryBookName)){
            list = bookService.queryAllBook();
            model.addAttribute("error", "未输入名称");
        }else {
            Book book = bookService.queryBooKByName(queryBookName);
            if (book == null){
                model.addAttribute("error", "未查到该书籍");
            }
            list.add(book);
        }
        model.addAttribute("list", list);
        return "allBook";
    }


}
