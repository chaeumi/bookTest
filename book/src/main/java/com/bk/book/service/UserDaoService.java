package com.bk.book.service;
import com.bk.book.repository.UserRepository;
import com.bk.book.bean.UserInfo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserDaoService {


    private static int usersCount = 0;
    private UserRepository userRepository;

    public List<UserInfo> findAll() {

        return userRepository.findAll();
    }

    @Transactional
    public UserInfo saveUser(UserInfo userInfo) {

        if (userInfo.getUserSeq() == null) {
            userInfo.setUserSeq(++usersCount);


            return userRepository.save(userInfo);
        }
        return userInfo;
    }
}
