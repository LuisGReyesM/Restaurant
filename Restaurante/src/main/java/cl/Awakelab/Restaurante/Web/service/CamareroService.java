package cl.Awakelab.Restaurante.Web.service;

import cl.Awakelab.Restaurante.Model.Domain.dto.CamareroDTO;


import java.util.List;
import java.util.Optional;

public interface CamareroService {
    Optional<List<CamareroDTO>> findAll();
    Optional <CamareroDTO> findById(int id);
}
