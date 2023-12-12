package com.bk.book.controller;


import com.bk.book.bean.BookInfo;
import com.bk.book.bean.LoanHistory;
import com.bk.book.service.LoanDaoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class LoanController {

    private LoanDaoService service;


    //대여 목록
    @GetMapping("/loanlist/{bookId}")
    public List<LoanHistory> LoanHistoryList(@PathVariable("bookId") Integer bookId){

        return service.findAll (bookId);

    }

    //대여
    @PostMapping("/rental/{bookId}/{userId}")
    public LoanHistory rentBook(LoanHistory loanHistory, @PathVariable("bookId") Integer bookId, @PathVariable("userId") String userId) {

       return service.saveLoan(loanHistory,bookId, userId);
    }

    //반납
    @Transactional
    @PutMapping("/return/{bookId}")
    public LoanHistory returnBook(@PathVariable("bookId") Integer bookId, LoanHistory loanHistory) {
        System.out.println(bookId);
        return service.returnBook(bookId, loanHistory);
    }



}
