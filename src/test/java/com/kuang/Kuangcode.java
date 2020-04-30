package com.kuang;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Kuangcode {
    public static void main(String[] args) {
        AutoGenerator tor = new AutoGenerator();

        GlobalConfig ig = new GlobalConfig();
        String projectpath=System.getProperty("user.dir");
        ig.setOutputDir(projectpath+"/src/main/java");
        ig.setAuthor("kuang");
        ig.setOpen(false);
        ig.setFileOverride(false);
        ig.setServiceImplName("%sSrvice");
        ig.setIdType(IdType.ID_WORKER);
        ig.setDateType(DateType.ONLY_DATE);
        ig.setSwagger2(true);
        tor.setGlobalConfig(ig);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306?studnet&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        tor.setDataSource(dsc);

        PackageConfig pg = new PackageConfig();
        pg.setModuleName("cktest");
        pg.setParent("com.kuang");
        pg.setEntity("pojo");
        pg.setMapper("mapper");
        pg.setService("service");
        pg.setController("controller");
        pg.setServiceImpl("serviceImpl");
        tor.setPackageInfo(pg);

        StrategyConfig sg = new StrategyConfig();
        sg.setInclude("user");
        sg.setEntityLombokModel(true);
        sg.setNaming(NamingStrategy.underline_to_camel);
        sg.setColumnNaming(NamingStrategy.underline_to_camel);
        sg.setRestControllerStyle(true);
        tor.setStrategy(sg);


        tor.execute();



    }
}
