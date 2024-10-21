package com.ohgiraffers.section01.subsection01.field;

// controller 로 생각 !

import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = context.getBean(BookService.class);
        List<BookDTO> bookDTOList = bookService.selectAllBook();
        for (BookDTO bookDTO : bookDTOList) {
            System.out.println("book = " + bookDTO);

        }

        System.out.println(bookService.selectBookById(1));
    }
}
