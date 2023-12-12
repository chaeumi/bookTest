package com.bk.book.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class BookInfo {
    @Id
    @Column(name = "book_id" ,length = 20)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(length = 50)
    private String title;
    @Column(length = 50)
    private String author;
    @Column(length = 50)
    private String publisher;



}
