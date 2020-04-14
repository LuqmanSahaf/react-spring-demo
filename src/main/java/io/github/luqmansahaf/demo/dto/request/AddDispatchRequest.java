package io.github.luqmansahaf.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddDispatchRequest {
    private String name;
    private String country;
    private String color;
    private Float weight;
}
