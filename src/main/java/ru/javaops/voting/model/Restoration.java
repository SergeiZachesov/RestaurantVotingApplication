package ru.javaops.voting.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restoration")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restoration extends NamedEntity {

    @OneToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE) //https://stackoverflow.com/a/44988100/548473
    @JoinColumn(name = "restoration_id")
    private List<Menu> menus;
}