package ru.javaops.voting.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javaops.voting.model.Dish;
import ru.javaops.voting.service.DishService;

import java.net.URI;
import java.util.List;

import static ru.javaops.voting.web.DishController.DISH_URL;

@RestController
@RequestMapping(DISH_URL)
@AllArgsConstructor
public class DishController {

    static final String DISH_URL = "/dish";

    private DishService service;

    @GetMapping
    public List<Dish> getAllByRestoration(@RequestParam @Nullable Integer restorationId) {
        return service.getAllByRestoration(restorationId);
    }

    @GetMapping("/{id}")
    public Dish get(@PathVariable int id) {
        return service.get(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Dish dish, @PathVariable int id) {
        service.update(dish);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> createWithLocation(@RequestBody Dish dish) {
        Dish created = service.save(dish);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(DISH_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
