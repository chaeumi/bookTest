package com.bk.book.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class LoanHistory {
    @Id
    @Column(length = 15)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;


    @Column(name="user_id" ,length = 20)
    private String userId;


    @Column(name="book_id" ,length = 20)
    private Integer bookId;

    @NotNull
    @Column(length = 2)
    private String LoanStatus;


}
