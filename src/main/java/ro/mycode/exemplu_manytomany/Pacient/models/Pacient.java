package ro.mycode.exemplu_manytomany.Pacient.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.mycode.exemplu_manytomany.Medic.models.Medic;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Pacient")
@Table(
        name = "pacient"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pacient {
    @Id
    //fiecare are o secventa de generare
    //de expl pt doua modele nu o sa primeasca id in ordine crescatoare, ci individual
    @SequenceGenerator(
            name = "pacient_sequance",
            sequenceName = "pacient_sequance",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "pacient_sequance"
    )
    private Long id;


    //trebuie sa am validatori pt fiecare atribut
    @Column(
            name = "name"
    )
    @NotBlank(message = "name is necessary")
    private String nume;
    @Column(
            name = "varsta",
            nullable = false
    )
    private int varsta;
    @Pattern(regexp = "^(true|false)$", message = "areIstoricMedical field allowed input: true or false")
    private boolean areIstoricMedical;




    @ManyToMany(mappedBy="pacients",
            fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Medic> medici= new ArrayList<>();




}
