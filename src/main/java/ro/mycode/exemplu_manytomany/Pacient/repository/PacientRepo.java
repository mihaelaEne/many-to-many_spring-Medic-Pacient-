package ro.mycode.exemplu_manytomany.Pacient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.exemplu_manytomany.Pacient.models.Pacient;

import java.util.List;

@Repository
public interface PacientRepo extends JpaRepository<Pacient,Long> {

    @Query("SELECT DISTINCT p.nume FROM Pacient p")
    List<String>getAllPacientsNames();




}
