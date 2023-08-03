package cl.Awakelab.Restaurante.Web.service;

import cl.Awakelab.Restaurante.Model.Domain.dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<List<UsuarioDTO>> findAll();
    Optional <UsuarioDTO> findById(int id);
    Optional<UsuarioDTO> create(UsuarioDTO usuarioDTO);
    Optional<UsuarioDTO> update(UsuarioDTO usuarioDTO);
    boolean delete(int id);

}
