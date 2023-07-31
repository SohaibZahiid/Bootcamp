package com.example.ejercicioslombok.entities;

import lombok.*;

import java.io.Serializable;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    private String surname;
}
