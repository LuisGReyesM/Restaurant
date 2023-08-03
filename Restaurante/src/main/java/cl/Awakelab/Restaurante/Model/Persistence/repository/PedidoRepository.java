package cl.Awakelab.Restaurante.Model.Persistence.repository;

import cl.Awakelab.Restaurante.Model.Persistence.entity.Pedido;
import cl.Awakelab.Restaurante.Model.Persistence.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}
