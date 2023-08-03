package cl.Awakelab.Restaurante.Model.Persistence.repository;

import cl.Awakelab.Restaurante.Model.Persistence.entity.Camarero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CamareroRepository extends JpaRepository<Camarero,Integer> {
}
