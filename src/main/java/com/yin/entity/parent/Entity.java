package com.yin.entity.parent;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共属性父类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entity {

    @TableField(exist = false)
    private Integer pageNumber;
    @TableField(exist = false)
    private Integer pageSize;
}
