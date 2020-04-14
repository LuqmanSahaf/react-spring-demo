package io.github.luqmansahaf.demo.repository;

import java.util.List;

import io.github.luqmansahaf.demo.entity.Country;
import io.reactivex.Single;

public interface CountryRepositoryCustom {
    Single<Country> findByName(String name);
    Single<List<Country>> findAll();
}
