package cl.Awakelab.Restaurante.Model.Persistence.repository;

import cl.Awakelab.Restaurante.Model.Persistence.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatoRepository extends JpaRepository<Plato,Integer> {
}
