package io.github.luqmansahaf.demo.entity;

import java.io.Serializable;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country implements Serializable {
    @Id
    private String name;
    @NonNull private Float multiplier;
}
