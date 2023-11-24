package ro.mycode.exemplu_manytomany.Medic.service;


import org.springframework.stereotype.Service;
import ro.mycode.exemplu_manytomany.Medic.exceptions.MedicExistException;
import ro.mycode.exemplu_manytomany.Medic.models.Medic;
import ro.mycode.exemplu_manytomany.Medic.repository.MedicRepo;

import java.util.List;

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
}
