package com.ohgiraffers.section01.subsection03.setter;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceSetter")
public class BookService {

    private BookDAO bookDAO;
    // setter 는 생성되고 좀 뒤에 들어오기에 (타이밍이 더 늦기때문에) final 을 붙이면 안된다.

   public void setBookDAO(BookDAO bookDAO) {
       this.bookDAO = bookDAO;
   }

    public List<BookDTO> selectBooks(){
        return bookDAO.selectBookList();
    }

    public BookDTO selectOneBook(int seq){
        return bookDAO.selectOneBook(seq);
    }


}
