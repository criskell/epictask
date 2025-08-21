package com.criskell.epictask.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private Long id;
    private String title;
    private String description;
    private int score;
    private int status;
}
