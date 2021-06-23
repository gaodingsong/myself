package com.example.entity.linux1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterConditionTO implements Serializable {
    private String name;
    private String filterType;
    private List<String> filterValue;
}
