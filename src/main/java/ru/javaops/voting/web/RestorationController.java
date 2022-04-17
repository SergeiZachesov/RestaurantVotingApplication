package ru.javaops.voting.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javaops.voting.model.Restoration;
import ru.javaops.voting.service.RestorationService;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class RestorationController {

    private final String URL_ADMIN = "admin/restorations";
    private final String URL_PROFILE = "profile/restorations";

    private RestorationService service;

    @GetMapping(URL_PROFILE)
    public List<Restoration> getAll() {
        return service.getAll();
    }

    @GetMapping(URL_PROFILE + "/{id}")
    public Restoration get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping(value = URL_ADMIN, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restoration> createWithLocation(@RequestBody Restoration restoration) {
        Restoration created = service.save(restoration);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL_PROFILE + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = URL_ADMIN + "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restoration restoration, @PathVariable int id) {
        restoration.setId(id);
        service.update(restoration);
    }

    @DeleteMapping(URL_ADMIN + "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
