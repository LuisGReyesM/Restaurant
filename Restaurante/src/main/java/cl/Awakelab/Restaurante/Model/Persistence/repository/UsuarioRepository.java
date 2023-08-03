package cl.Awakelab.Restaurante.Model.Persistence.repository;


import cl.Awakelab.Restaurante.Model.Persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
