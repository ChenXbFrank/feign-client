package com.frank.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.frank.domain.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 小石潭记
 * @date 2020/6/25 12:02
 * @Description: ${todo}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("users")
    private List<User> users;

    @JsonProperty("address")
    private String address;
}
