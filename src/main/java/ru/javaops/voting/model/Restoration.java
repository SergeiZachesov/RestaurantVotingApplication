package ru.javaops.voting.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.javaops.voting.HasId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restoration")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restoration extends NamedEntity implements HasId {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restoration")
    @OnDelete(action = OnDeleteAction.CASCADE) //https://stackoverflow.com/a/44988100/548473
    @JsonManagedReference
    private List<Dish> dishes;
}
