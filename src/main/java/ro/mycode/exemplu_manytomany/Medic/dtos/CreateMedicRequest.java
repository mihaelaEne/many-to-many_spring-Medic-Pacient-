package ro.mycode.exemplu_manytomany.Medic.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateMedicRequest {
    private String nume;
    private char initialaTatalui;
    private String specialitate;
    private int aniExperientia;
}
