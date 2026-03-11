package com.basic.myspringboot.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MyEnvironment {
    private String mode;
}