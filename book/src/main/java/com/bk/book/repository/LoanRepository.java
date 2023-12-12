package com.bk.book.repository;


import com.bk.book.bean.LoanHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<LoanHistory, String> {


    //  List<LoanHistoryDto> findAllByBook(Integer bookId);
}
