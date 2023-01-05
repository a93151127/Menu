package com.example.demo.resource;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OPResource {
    private String message;
    private Object errors;
}
