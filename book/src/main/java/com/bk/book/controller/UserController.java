package com.bk.book.controller;

import com.bk.book.bean.UserInfo;
import com.bk.book.service.UserDaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserDaoService service;

    //회원가입 확인용 유저 목록
    @GetMapping("/users")
    public List<UserInfo> usersList() {
        return service.findAll();
    }

    //회원가입
    @PostMapping("/saveusers")
    public ResponseEntity<UserInfo> createUser(@Valid @RequestBody UserInfo userInfo) {
        UserInfo saveUserInfo = service.saveUser(userInfo);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(saveUserInfo.getUserSeq())
                    .toUri();

        return ResponseEntity.ok(saveUserInfo);
    }



}
