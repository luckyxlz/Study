package com.lucky;

import com.lucky.service.BookService;
import com.lucky.service.impl.BookServiceImp;

public class App {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImp();
        bookService.save();
    }
}
