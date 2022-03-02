package com.github.liuxg.jvm.cglib;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class UserBean implements Serializable {
    private String id;

    private String name;
}
