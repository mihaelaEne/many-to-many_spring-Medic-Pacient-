package ro.mycode.exemplu_manytomany.Medic.service;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.mycode.exemplu_manytomany.Medic.dtos.CreateMedicRequest;
import ro.mycode.exemplu_manytomany.Medic.exceptions.MedicExistException;
import ro.mycode.exemplu_manytomany.Medic.models.Medic;
import ro.mycode.exemplu_manytomany.Medic.repository.MedicRepo;

import java.util.List;
import java.util.Optional;

@Service
public class MedicService {

private MedicRepo medicRepo;

    public MedicService(MedicRepo medicRepo) {
        this.medicRepo = medicRepo;
    }

    public List<Medic>getAllMedici(){
        List<Medic> all=medicRepo.findAll();
        if(all.size()==0){
            throw new MedicExistException();
        }
        return all;
    }

    @Transactional
    public void addMedic(CreateMedicRequest createMedicRequest){
        Optional<Medic>medicByName=medicRepo.findMedicByNume(createMedicRequest.getNume());

        if(medicByName.isPresent()){
            throw new MedicExistException();

        }

        Medic medic=Medic.builder()
                .nume(createMedicRequest.getNume())
                .initialaTatalui(createMedicRequest.getInitialaTatalui())
                .specialitate(createMedicRequest.getSpecialitate())
                .aniExperientia(createMedicRequest.getAniExperientia())
                .build();

        medicRepo.saveAndFlush(medic);
    }
}
