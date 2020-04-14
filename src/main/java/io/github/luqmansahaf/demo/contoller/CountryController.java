package io.github.luqmansahaf.demo.contoller;

import java.util.List;

import io.github.luqmansahaf.demo.entity.Country;
import io.github.luqmansahaf.demo.service.CountryService;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    @Autowired CountryService countryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Single<ResponseEntity<List<Country>>> getAllCountries() {
        return countryService.getAllCountries().subscribeOn(Schedulers.io())
            .map(ResponseEntity::ok);
    }
}
