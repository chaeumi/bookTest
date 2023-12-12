package com.bk.book.repository;

import com.bk.book.bean.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookInfo, Integer> {
}
