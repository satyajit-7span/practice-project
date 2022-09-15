package com.spring.jdbc.demo.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    private long id;

    @NonNull
    private String name;

    @NonNull
    private String city;

    @NonNull
    private LocalDate birthdate;
}
