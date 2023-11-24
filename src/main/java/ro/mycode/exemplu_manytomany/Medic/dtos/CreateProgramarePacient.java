package ro.mycode.exemplu_manytomany.Medic.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProgramarePacient {

    private int pacientId;
    private int medicId;


}
