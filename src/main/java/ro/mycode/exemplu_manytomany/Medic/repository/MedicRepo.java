package ro.mycode.exemplu_manytomany.Medic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.exemplu_manytomany.Medic.models.Medic;

import java.util.List;

@Repository
public interface MedicRepo extends JpaRepository<Medic,Long> {

    @Query("SELECT DISTINCT m.nume FROM Medic m")
    List<String> getAllMedicNames();




}
