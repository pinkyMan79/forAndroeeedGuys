package org.example.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaroResponse {

    private String dignity;
    private String description;
    private String lasso;
    private String suit;
    private String name;

}
