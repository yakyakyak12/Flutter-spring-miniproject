package com.example.kakao.book;

import org.springframework.stereotype.Service;

import com.example.kakao._core.errors.exception.Exception404;
import com.example.kakao.book.BookResponse.BookDetailDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookJPARepository bookJPARepository;

    public BookResponse.BookDetailDTO 상세보기(Integer id) {
        Book bookPs = bookJPARepository.findById(id).orElseThrow(() -> new Exception404("존재하지 않는 도서입니다. : " + id));
        return new BookDetailDTO(bookPs);
    }

}
