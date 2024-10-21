package com.ohgiraffers.section01.subsection02.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor")
public class BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        // 필드에 있는것과 생성자에 있는것의 차이는 생성자에 있으면 순환오류 없이 어플리케이션이 실행될 때
        // 순환참조의 오류가 있으면 미리 뱉는다. 따라서 안정성이 좀 더 보장된다.
        // 구동 자체는 비슷하다.
    }

    public List<BookDTO> selectBooks(){
        return bookDAO.selectBookList();
    }

    public BookDTO selectOneBook(int seq){
        return bookDAO.selectOneBook(seq);
    }


}
