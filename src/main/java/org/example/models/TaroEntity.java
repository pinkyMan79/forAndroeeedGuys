package org.example.models;

import liquibase.pro.packaged.A;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "taro_card_table")
public class TaroEntity extends AbstractEntity{

    @Column
    private String dignity;
    @Column
    private String description;
    @Column
    private String lasso;

    @Column(nullable = true)
    private String suit;
    @Column(nullable = true)
    private String name;



}
