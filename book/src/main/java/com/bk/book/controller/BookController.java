package com.bk.book.controller;

import com.bk.book.bean.BookInfo;
import com.bk.book.service.BookDaoService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

    private BookDaoService bookService;

    //도서 목록
    @GetMapping("/booklist")
    public List<BookInfo> bookList() {

        return bookService.findAll();
    }

    //도서 등록
    @PostMapping("/savebook")
    public BookInfo saveBook(@RequestBody BookInfo bookInfo) {

        return bookService.saveBook(bookInfo);
    }

    //도서 수정
    @Transactional
    @PutMapping("/updatebook/{bookId}")
    public BookInfo updateBook(@RequestBody BookInfo bookInfo, @PathVariable("bookId") Integer bookId) {
        BookInfo modifyBookInfo = bookService.updateBook(bookId, bookInfo);
       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/bookId}")
               .buildAndExpand(modifyBookInfo.getBookId())
                .toUri();

        return bookService.updateBook(bookId, bookInfo);
    }
}
