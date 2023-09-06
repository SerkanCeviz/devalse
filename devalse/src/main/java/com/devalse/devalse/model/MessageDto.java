package com.devalse.devalse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MessageDto {

    private UUID id;
    private String name;
    private String email;
    private String message;
    private String productName;
    private LocalDate requestTime;
}
