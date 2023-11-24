package ro.mycode.exemplu_manytomany.Medic.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.exemplu_manytomany.Medic.models.Medic;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicRepo extends JpaRepository<Medic, Long> {

    @Query("SELECT DISTINCT m.nume FROM Medic m")
    List<String> getAllMedicNames();

    @Query("SELECT m from Medic m where m.nume= ?1")
    @EntityGraph(attributePaths = {"medic"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Medic> findMedicByNume(String nume);


}
