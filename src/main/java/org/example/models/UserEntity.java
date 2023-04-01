package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "u_table") // can not be able to named user -> because the relation USER is already exist in PostgreSQL
public class UserEntity extends AbstractEntity{

    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Instant birth;
    @Column
    private Boolean male;

}
