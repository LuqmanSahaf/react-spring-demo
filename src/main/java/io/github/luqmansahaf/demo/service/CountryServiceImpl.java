package io.github.luqmansahaf.demo.service;

import java.util.List;

import io.github.luqmansahaf.demo.entity.Country;
import io.github.luqmansahaf.demo.repository.CountryRepositoryCustomImpl;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepositoryCustomImpl countryRepository;

    @Override
    public Single<List<Country>> getAllCountries() {
        return countryRepository.findAll();
    }
}
