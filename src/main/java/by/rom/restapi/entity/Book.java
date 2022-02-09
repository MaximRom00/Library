package by.rom.restapi.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "books")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false, of = {"name"})
@ToString(exclude = "author")

public class Book extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int year;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book", cascade = {CascadeType.REMOVE})
    private List<Library> library;
}
