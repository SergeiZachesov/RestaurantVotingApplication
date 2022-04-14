package ru.javaops.voting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.javaops.voting.model.Dish;
import ru.javaops.voting.repository.DishRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DishService {

    private DishRepository repository;

    public List<Dish> getAllByRestoration(Integer restorationId) {
        return repository.getAllByRestoration(restorationId);
    }

    public Dish get(int id) {
        return repository.getById(id);
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
