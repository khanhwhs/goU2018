package com.home.gou.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class User {

    private int userId;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("userPassword")
    private String userPassword;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phoneNo")
    private String phoneNo;
    private String isDriverFlag;
    private String drivingLn;

    public User(){
    }
}
