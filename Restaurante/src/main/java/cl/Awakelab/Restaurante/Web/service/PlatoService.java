package cl.Awakelab.Restaurante.Web.service;

import cl.Awakelab.Restaurante.Model.Domain.dto.PlatoDTO;

import java.util.List;
import java.util.Optional;


public interface PlatoService {

    Optional<List<PlatoDTO>> findAll();
    Optional <PlatoDTO> findById(int id);
    Optional<PlatoDTO> create(PlatoDTO platoDTO);
    Optional<PlatoDTO> update(PlatoDTO platoDTO);
    boolean delete(int id);
}
