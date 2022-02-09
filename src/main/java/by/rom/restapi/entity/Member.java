package by.rom.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "member")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false, of = "telephoneNumber")
public class Member extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String telephoneNumber;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Library> library;
}
