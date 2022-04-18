package ru.javaops.voting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.voting.model.Dish;
import ru.javaops.voting.repository.DishRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DishService {

    private DishRepository repository;

    public List<Dish> getAll() {
        return repository.findAll();
    }

    public Dish get(int id) {
        return repository.findById(id).orElse(null);
    }

    public Dish save(Dish dish) {
        return repository.save(dish);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public void update(Dish dish) {
        repository.save(dish);
    }
}
