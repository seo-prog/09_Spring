package com.ohgiraffers.section01.common;


import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("bookDAO") // 데이터베이스 쪽과 연결을 맺는 객체. // 얘도 components 처럼 bean 으로 인식.
public class BookDAOImpl implements BookDAO {

    private Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1, 123, "자바의정석", "남궁성", "도우출판", new Date()));
        bookList.put(2, new BookDTO(2, 456, "컨테이너", "문성주", "길벗", new Date()));
    }


    @Override
    public List<BookDTO> selectBookList() {
        // 전체 책 조회
        return new ArrayList<>(bookList.values());
        // bookList.values() 가 우리가 넣어준 bookDTO 이다.
    }

    @Override
    public BookDTO selectOneBook(int seq) {
        // 도서 번호로 책 조회
        return bookList.get(seq);
    }
}
