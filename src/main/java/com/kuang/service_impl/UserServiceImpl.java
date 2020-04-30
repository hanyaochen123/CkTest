package com.kuang.service_impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuang.mapper.Usermapper;
import com.kuang.pojo.User;
import com.kuang.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<Usermapper, User> implements UserService {

}
