package ru.javaops.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javaops.voting.model.Restoration;

public interface RestorationRepository extends JpaRepository<Restoration, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Restoration r WHERE r.id=:id")
    int delete(@Param("id") int id);
}
