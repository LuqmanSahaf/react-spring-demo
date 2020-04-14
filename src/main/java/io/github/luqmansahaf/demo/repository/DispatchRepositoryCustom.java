package io.github.luqmansahaf.demo.repository;

import java.util.List;

import io.github.luqmansahaf.demo.entity.Dispatch;
import io.reactivex.Single;

public interface DispatchRepositoryCustom {
    Single<Dispatch> save(Dispatch dispatch);
    Single<List<Dispatch>> findAll();
}
