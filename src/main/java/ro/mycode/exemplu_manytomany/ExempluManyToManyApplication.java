package ro.mycode.exemplu_manytomany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.exemplu_manytomany.Medic.dtos.CreateMedicRequest;
import ro.mycode.exemplu_manytomany.Medic.models.Medic;
import ro.mycode.exemplu_manytomany.Medic.repository.MedicRepo;
import ro.mycode.exemplu_manytomany.Medic.service.MedicService;
import ro.mycode.exemplu_manytomany.Pacient.models.Pacient;
import ro.mycode.exemplu_manytomany.Pacient.repository.PacientRepo;
import ro.mycode.exemplu_manytomany.Pacient.service.PacientService;

@SpringBootApplication
public class ExempluManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExempluManyToManyApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(MedicRepo medicRepo, PacientRepo pacientRepo, MedicService medicService, PacientService pacientService) {
        return args ->{
            Medic medic=medicRepo.findById(2L).get();
            Pacient pacient=pacientRepo.findById(4L).get();

            Pacient pacient1=pacientRepo.findById(7L).get();

            medic.adaugaPacient(pacient1);


            medicRepo.saveAndFlush(medic);


        };






	}


}
