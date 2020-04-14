package io.github.luqmansahaf.demo.contoller;

import java.util.List;

import io.github.luqmansahaf.demo.dto.request.AddDispatchRequest;
import io.github.luqmansahaf.demo.entity.Dispatch;
import io.github.luqmansahaf.demo.service.DispatchService;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {
    @Autowired
    DispatchService dispatchService;

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<Dispatch> addDispatch(@RequestBody AddDispatchRequest addDispatchRequest) {
        return dispatchService.addDispatch(addDispatchRequest);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Single<ResponseEntity<List<Dispatch>>> getAllDispatches() {
        return dispatchService.getAllDispatches().subscribeOn(Schedulers.io())
            .map(ResponseEntity::ok);
    }
}
