package com.example.demo.resource;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FieldResource {
    private String resource;
    private String field;
    private String code;
    private String message;
}
