package com.bk.book.service;

import com.bk.book.bean.LoanHistory;
import com.bk.book.repository.LoanRepository;
import exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoanDaoService {


    private static long loanCount = 0;
    private static String loanStatus = "0"; //대여중
    private LoanRepository loanRepository;


    @Transactional
    public LoanHistory saveLoan(LoanHistory loan, Integer bookId, String userId) {

        if (loan.getLoanId() == null) {
            loan.setLoanId(++loanCount);
            loan.setLoanStatus(loanStatus);
            loan.setBookId(bookId);
            loan.setUserId(userId);
            return loanRepository.save(loan);
        }
        return loan;
    }

    @Transactional
    public LoanHistory returnBook(Integer bookId, LoanHistory loanHistory ) {
        LoanHistory loan = new LoanHistory();
        loan.setLoanStatus("1"); //반납
        loan.setBookId(bookId);
        return loanRepository.save(loan);
    }





        public List<LoanHistory> findAll(Integer bookId) {
        return loanRepository.findAll();
    }




}
