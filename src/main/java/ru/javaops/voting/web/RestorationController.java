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

import static ru.javaops.voting.web.RestorationController.RESTORATION_URL;

@RestController
@RequestMapping(RESTORATION_URL)
@AllArgsConstructor
public class RestorationController {

    static final String RESTORATION_URL = "/restorations";

    private RestorationService service;

    @GetMapping
    public List<Restoration> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Restoration get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restoration> createWithLocation(@RequestBody Restoration restoration) {
        Restoration created = service.save(restoration);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(RESTORATION_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restoration restoration, @PathVariable int id) {
        restoration.setId(id);
        service.update(restoration);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
