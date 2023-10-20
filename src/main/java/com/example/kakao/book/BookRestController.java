package com.example.kakao.book;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakao._core.utils.ApiUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BookRestController {

    private final BookService bookService;

    // 책 리스트
    @GetMapping("/books")
    public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page){
        List<BookResponse.FindAllDTO> responseDTO = bookService.findAll(page);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
}
