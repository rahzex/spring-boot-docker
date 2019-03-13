package com.stackroute.playerservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    private int id;

    @NotNull
    @Size(min = 3)
    private String name;

    @NotNull
    private int score;
}
