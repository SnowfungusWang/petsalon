package njuics.demos.petsalon.repository;

import njuics.demos.petsalon.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
