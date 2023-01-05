package com.example.demo.application;

import com.example.demo.exception.OPException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Student {
    private List<Test> testList;

    public String getExc() throws OPException {
        throw new OPException("M1234", "3333");
    }
}
