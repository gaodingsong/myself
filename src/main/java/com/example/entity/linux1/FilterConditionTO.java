package com.example.entity.linux1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author majiawei
 * @classname FilterCondition
 * @desc
 * @date create in 2020/9/7 15:19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterConditionTO implements Serializable {
    private String name;
    private String filterType;
    private List<String> filterValue;
}
