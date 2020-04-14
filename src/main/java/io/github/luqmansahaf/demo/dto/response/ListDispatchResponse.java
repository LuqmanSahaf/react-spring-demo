package io.github.luqmansahaf.demo.dto.response;

import java.util.List;

import io.github.luqmansahaf.demo.entity.Dispatch;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListDispatchResponse {
    List<Dispatch> dispatches;
}
