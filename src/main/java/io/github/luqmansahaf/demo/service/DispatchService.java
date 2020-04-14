package io.github.luqmansahaf.demo.service;

import java.util.List;

import io.github.luqmansahaf.demo.dto.request.AddDispatchRequest;
import io.github.luqmansahaf.demo.entity.Dispatch;
import io.reactivex.Single;

public interface DispatchService {
    Single<Dispatch> addDispatch(AddDispatchRequest addDispatchRequest);
    Single<List<Dispatch>> getAllDispatches();
}
