package njuics.demos.petsalon.repository;

import njuics.demos.petsalon.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
