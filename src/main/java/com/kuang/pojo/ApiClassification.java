package com.kuang.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiClassification {
    private int id;
    private Integer projectId;
    private String name;
    private String description;
    private Integer createUser;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
