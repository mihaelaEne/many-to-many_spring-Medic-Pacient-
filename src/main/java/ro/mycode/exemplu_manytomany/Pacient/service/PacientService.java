package ro.mycode.exemplu_manytomany.Pacient.service;

import org.springframework.stereotype.Service;
import ro.mycode.exemplu_manytomany.Medic.exceptions.MedicExistException;
import ro.mycode.exemplu_manytomany.Medic.models.Medic;
import ro.mycode.exemplu_manytomany.Pacient.exceptions.PacientExistException;
import ro.mycode.exemplu_manytomany.Pacient.models.Pacient;
import ro.mycode.exemplu_manytomany.Pacient.repository.PacientRepo;

import java.util.List;

@Service

public class PacientService {

    private PacientRepo pacientRepo;

    public PacientService(PacientRepo pacientRepo) {
        this.pacientRepo = pacientRepo;
    }

    public List<Pacient>getAllPacienti(){
        List<Pacient>all=pacientRepo.findAll();
        if(all.size()==0){
            throw new PacientExistException();
        }
        return all;
    }


}
