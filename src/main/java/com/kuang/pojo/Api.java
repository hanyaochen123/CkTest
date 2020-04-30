package com.kuang.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Api {
    private int id;
    private Integer apiClassificationId;
    private String name;
    private String method;
    private String url;
    private String description;
    private Integer createUser;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
