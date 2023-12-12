package com.bk.book.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

public class UserInfo {
    @Id
    @Column(length = 15)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer userSeq;


    @Column(name = "user_id" ,length = 20)
    private String userId;

    @Column(length = 20)
    private String password;


    @Size(min = 2 , max = 10)
    @Column(length = 20)
    private String name;
}
