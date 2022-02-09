package by.rom.restapi.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "authors")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, of = "name")
public class Author extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
