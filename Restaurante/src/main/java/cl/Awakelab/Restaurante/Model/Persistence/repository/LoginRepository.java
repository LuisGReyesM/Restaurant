package cl.Awakelab.Restaurante.Model.Persistence.repository;

import cl.Awakelab.Restaurante.Model.Persistence.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByUsername(String s);
}