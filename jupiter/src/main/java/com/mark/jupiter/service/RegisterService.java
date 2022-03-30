package com.mark.jupiter.service;

import com.mark.jupiter.dao.RegisterDao;
import com.mark.jupiter.entity.db.User;
import com.mark.jupiter.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class RegisterService {

    @Autowired
    private RegisterDao registerDao;

    public boolean register(User user) throws IOException {
        user.setPassword(Util.encryptPassword(user.getUserId(), user.getPassword()));

        return registerDao.register(user);
    }
}

