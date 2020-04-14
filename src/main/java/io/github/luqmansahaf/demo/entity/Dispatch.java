package io.github.luqmansahaf.demo.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dispatch implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull @NotEmpty
    private String name;
    @NotNull
    private Float weight;
    @NotNull @NotEmpty
    private String color;
    private String destination;

    public String toSQLInsertString() {
        return "INSERT INTO dispatch (name,color,weight,destination) VALUES ('" + name + "','" + color + "'," + weight + ",'" + destination + "')";
    }
}
