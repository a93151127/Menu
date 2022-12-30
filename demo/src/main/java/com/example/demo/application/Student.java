package com.example.demo.application;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Student {
    private List<Test> testList;
}
