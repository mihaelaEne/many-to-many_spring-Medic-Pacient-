package ro.mycode.exemplu_manytomany.Medic.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ro.mycode.exemplu_manytomany.Pacient.models.Pacient;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Medic")
@Table(
        name = "medic"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Medic {

    @Id
    @SequenceGenerator(
            name = "medic_sequance",
            sequenceName = "medic_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "medic_sequance"
    )
    private Long id;

    @Column(
            name = "name"
    )
    @NotBlank(message = "name is necessary")
    private String nume;


    private char initialaTatalui;

    @Column(
            name = "specialitate"
    )
    @NotBlank(message = "specialitate is necessary")
    private String specialitate;
    @NotNull(message = "aniExperienta is necessary")
    private int aniExperientia;


    @JsonManagedReference
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER

    )
    @JoinTable(name = "programare",
            joinColumns = {@JoinColumn(name = "medic_id")},
            inverseJoinColumns = {@JoinColumn(name = "pacient_id")})
    @Builder.Default

    private List<Pacient> pacients = new ArrayList<>();


    public void adaugaPacient(Pacient pacient) {
        pacients.add(pacient);
    }


}

