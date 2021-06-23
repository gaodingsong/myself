package com.example.entity.linux1;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class PlatformRequestParamTO implements Serializable {
    private List<String> cols;
    private List<FilterConditionTO> filters;
    private Integer limit;
    private Integer offset;
    private String sort;
    private String order;
    @JsonAlias("only_total")
    @JsonProperty("only_total")
    private Boolean onlyTotal;
}
