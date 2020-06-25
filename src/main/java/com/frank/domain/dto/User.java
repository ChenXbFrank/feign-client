package com.frank.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小石潭记
 * @date 2020/6/22 21:42
 * @Description: ${todo}
 */
@Data
public class User {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    public String name;

    @JsonProperty("age")
    public int age;

    public User(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(){

    }
}
