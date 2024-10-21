package com.ohgiraffers.section01.subsection01.field;


import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service("bookServiceField") // 이것도 빈으로 등록해주는거다.
public class BookService {

    @Autowired
    //필드주입 -- Autowired 로 annotation 을 한 후에 만약 적어준 BookDAO 가 인터페이스이면 인터페이스를 정의해준 구현체 (BookDAOImpl)를 찾아간다.
    private BookDAO bookDAO;  // 우리가 bookDAO 를 가지고 있어야 DAO 사용 가능.


    public List<BookDTO> selectAllBook(){
        return bookDAO.selectBookList();
    }

    public BookDTO selectBookById(int seq){
        return bookDAO.selectOneBook(seq);
    }


}
