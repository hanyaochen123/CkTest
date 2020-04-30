package com.kuang;

import com.kuang.mapper.Usermapper;
import com.kuang.pojo.User;
import com.kuang.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class DemoplusApplicationTests {
    @Autowired
    private Usermapper usermapper;
    @Autowired
    private UserService service;


    @Test
    void contextLoads() throws SQLException {




    }

}
