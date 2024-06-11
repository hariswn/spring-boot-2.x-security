package com.harry.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 7785478947854523L;

    private String userName;
    private String password;

}
