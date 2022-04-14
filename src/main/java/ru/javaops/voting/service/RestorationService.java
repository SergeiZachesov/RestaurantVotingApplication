package ru.javaops.voting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaops.voting.model.Restoration;
import ru.javaops.voting.repository.RestorationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RestorationService {

    private RestorationRepository repository;

    public List<Restoration> getAll() {
        return repository.findAll();
    }

    public Restoration get(int id) {
        return repository.findById(id).orElse(null);
    }

    public void update(Restoration restoration) {
        repository.save(restoration);
    }

    public Restoration save(Restoration restoration) {
        return repository.save(restoration);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}