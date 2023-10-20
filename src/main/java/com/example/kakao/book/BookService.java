package com.example.kakao.book;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookJPARepository bookJPARepository;

    // 책 리스트
    public List<BookResponse.FindAllDTO> findAll(int page){
        Pageable pageable = PageRequest.of(page, 9);
        Page<Book> pageContent = bookJPARepository.findAll(pageable);
        List<BookResponse.FindAllDTO> responseDTO = pageContent.getContent().stream()
                                        .map(book -> new BookResponse.FindAllDTO(book))
                                        .collect(Collectors.toList());
        return responseDTO;
    }
}
