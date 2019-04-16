package njuics.demos.petsalon.repository;

import njuics.demos.petsalon.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,Long> {
}
