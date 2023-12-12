package com.bk.book.service;

import com.bk.book.repository.BookRepository;
import com.bk.book.bean.BookInfo;
import exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

    @AllArgsConstructor
    @Service
    public class BookDaoService {

        private BookRepository bookRepository;
        private static int bookCount = 0;
        public List<BookInfo> findAll() {
            return bookRepository.findAll();
        }


        @Transactional
        public BookInfo saveBook(BookInfo bookInfo) {

            if (bookInfo.getBookId() == null) {
                bookInfo.setBookId(++bookCount);

                return bookRepository.save(bookInfo);
            }
            return bookInfo;
        }

        @Transactional
        public BookInfo updateBook(Integer bookId, BookInfo newBookInfo) {
            BookInfo bookInfo = bookRepository.findById(bookId)
                    .orElseThrow(() -> new NotFoundException("BookInfo", "bookId", bookId));
            bookInfo.setTitle(newBookInfo.getTitle());
            bookInfo.setAuthor(newBookInfo.getAuthor());
            bookInfo.setPublisher(newBookInfo.getPublisher());
            return bookRepository.save(bookInfo);
        }

    }




