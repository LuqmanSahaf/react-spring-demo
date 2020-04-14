package io.github.luqmansahaf.demo.service;

import java.util.List;

import io.github.luqmansahaf.demo.entity.Country;
import io.reactivex.Single;

public interface CountryService {
    Single<List<Country>> getAllCountries();
}
