package com.kuang.service_impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kuang.mapper.Projectmapper;
import com.kuang.pojo.Project;
import com.kuang.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends ServiceImpl<Projectmapper, Project> implements ProjectService{

}
