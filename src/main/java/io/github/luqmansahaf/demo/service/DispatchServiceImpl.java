package io.github.luqmansahaf.demo.service;

import java.util.List;

import io.github.luqmansahaf.demo.entity.Dispatch;
import io.github.luqmansahaf.demo.repository.CountryRepositoryCustom;
import io.github.luqmansahaf.demo.repository.DispatchRepositoryCustomImpl;
import io.github.luqmansahaf.demo.dto.request.AddDispatchRequest;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchServiceImpl implements DispatchService {

    @Autowired
    private DispatchRepositoryCustomImpl dispatchRepository;

    @Autowired
    private CountryRepositoryCustom countryRepository;

    @Override
    public Single<Dispatch> addDispatch(AddDispatchRequest addDispatchRequest) {
        return saveDispatch(addDispatchRequest);
    }

    @Override
    public Single<List<Dispatch>> getAllDispatches() {
        return dispatchRepository.findAll();
    }

    private Single<Dispatch> saveDispatch(AddDispatchRequest addDispatchRequest){
        return dispatchRepository.save(toDispatch(addDispatchRequest));
    }

    private Dispatch toDispatch(AddDispatchRequest addDispatchRequest) {
        Dispatch dispatch = new Dispatch();
        dispatch.setName(addDispatchRequest.getName());
        dispatch.setColor(addDispatchRequest.getColor());
        dispatch.setDestination(addDispatchRequest.getCountry());
        dispatch.setWeight(addDispatchRequest.getWeight());
        return dispatch;
    }
}
